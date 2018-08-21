package hadoop;

/**
 * Create By 曹通
 * 2018/8/1 10:24
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

public class pingjunzhi {

    static final String INPUT_PATH = "hdfs://master:8020/avg.txt";
    static final String OUT_PATH = "hdfs://master:8020/outPut/test";
    public static void main(String[] args) throws Exception {
        // 主类
        Configuration conf = new Configuration();

        final Job job = Job.getInstance(conf, pingjunzhi.class.getSimpleName());
        job.setNumReduceTasks(1);
        job.setJarByClass(pingjunzhi.class);
        // 寻找输入
        FileInputFormat.setInputPaths(job, INPUT_PATH);
        // 1.2对输入数据进行格式化处理的类
        job.setInputFormatClass(TextInputFormat.class);
        job.setMapperClass(MyMapper.class);

        // 1.2指定map输出类型<key,value>类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        job.setReducerClass(MyReduce.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        // 指定输出路径
        FileOutputFormat.setOutputPath(job, new Path(OUT_PATH));
        // 指定输出的格式或则类
        job.setOutputFormatClass(TextOutputFormat.class);

        // 把作业提交
        job.waitForCompletion(true);

    }

    // map类
    static class MyMapper extends
            Mapper<LongWritable, Text, Text, DoubleWritable> {
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {

            String line = value.toString();
//            Counter countPrint = context.getCounter("Map输出传递Value", line);
//            // 计数器加一
//            countPrint.increment(1l);
            // 分别对每一行进行处理,可能一行有多个数字
            // 每行按空格划分
            StringTokenizer tokenizerLine = new StringTokenizer(line);
            double sum = 0;
            int count = 0;
            while (tokenizerLine.hasMoreElements()){
                String strScore = tokenizerLine.nextToken();// 个数部分
                double scoreInt = Double.parseDouble(strScore);
                sum += scoreInt;
                count ++;
            }
            // 输出
            context.write(new Text("avg"), new DoubleWritable(sum/count));
        }
    }

    // reduce类
    static class MyReduce extends
            Reducer<Text, DoubleWritable, Text, DoubleWritable> {
        @Override
        protected void reduce(Text key, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
            long sum = 0;
            long count = 0;
            Iterator<DoubleWritable> iterator = values.iterator();
            while (iterator.hasNext()) {
                sum += iterator.next().get();// 计算总值
                count++;// 统计个数
            }
            long average = (long) sum / count;// 计算平均值
            // key ===> avg
            context.write(key, new DoubleWritable(average));
        }
    }
}
