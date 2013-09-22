package com.hanyun.mapreduce;

import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class LoggingCount extends Configured implements Tool{
	
	public static class Map extends Mapper<LongWritable,Text,Text,IntWritable>
	{
		private final static IntWritable one=new IntWritable(1);
		private final String regex="sug\\/sug.jsp\\?q=([\\w+]*)";
		
		@Override
		protected void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException
		{
			//0:0:0:0:0:0:0:1 - - [21/Sep/2013:18:30:56 -0700] "GET /hadoop_search/sug/sug.jsp?q=baidu HTTP/1.1" 200 1491
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(value.toString());
			while(matcher.find())
			{
				if(!matcher.group(1).equals(""))
				{
					Text word=new Text(matcher.group(1).replace("+"," "));
					context.write(word, one);
				}
			}
		}
	}
	
	public static class Reduce extends Reducer<Text ,IntWritable,Text ,IntWritable>
	{
		protected void reduce(Text key,Iterator<IntWritable> values,Context context) throws IOException, InterruptedException
		{
			int sum=0;
			while(values.hasNext())
			{
				sum+=values.next().get();
			}
			context.write(key, new IntWritable(sum));
		}
	}

	public static void main(String[] args) throws Exception {
		int ret=ToolRunner.run(new LoggingCount(), args);
		System.exit(ret);
	}

	@Override
	public int run(String[] arg0) throws Exception {
		Configuration conf=getConf();
		
		Job job =new Job(conf,"RedisLogging");
		
		job.setJarByClass(LoggingCount.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(RedisOutputFormat.class);
		
		FileInputFormat.setInputPaths(job,new Path(arg0[0]));
		FileOutputFormat.setOutputPath(job, new Path(arg0[1]));
		return job.waitForCompletion(true)?0:1;
	}

}
