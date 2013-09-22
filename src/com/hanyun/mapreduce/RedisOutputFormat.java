package com.hanyun.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import redis.clients.jedis.Jedis;

public class RedisOutputFormat<K,V> extends FileOutputFormat<K,V> {

	public static class RedisRecordWriter<K,V> extends RecordWriter<K,V>{
		private Jedis jedis;
		
		RedisRecordWriter(Jedis jedis)
		{
			this.jedis=jedis;
		}
		
		@Override
		public void close(TaskAttemptContext arg0) throws IOException,
				InterruptedException {
			jedis.disconnect();
		}

		@Override
		public void write(K key, V value) throws IOException,
				InterruptedException {
			boolean nullkey =key ==null || key instanceof NullWritable;
			boolean nullvalue = value ==null || key instanceof NullWritable;
			
			if(nullkey||nullvalue)
			{
				return ;
			}
			
			String s=key.toString();
			
			for(int i=0;i<s.length();i++)
			{
				String k=s.substring(0,i+1);
				int score=Integer.parseInt(value.toString());
				jedis.zincrby(k, score,s);
			}
		}
	}
	
	@Override
	public RecordWriter<K, V> getRecordWriter(TaskAttemptContext arg0)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return new RedisRecordWriter<K,V>(new Jedis("127.0.0.1",18088));
	}

}
