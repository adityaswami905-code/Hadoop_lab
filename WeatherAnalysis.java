import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WeatherAnalysis {

    public static class WeatherMapper
            extends Mapper<Object, Text, Text, Text> {

        public void map(Object key,
                        Text value,
                        Context context)
                throws IOException, InterruptedException {

            String[] data = value.toString().split(" ");

            context.write(
                    new Text("weather"),
                    new Text(data[0] + "," +
                             data[1] + "," +
                             data[2]));
        }
    }

    public static class WeatherReducer
            extends Reducer<Text, Text,
            Text, DoubleWritable> {

        public void reduce(Text key,
                           Iterable<Text> values,
                           Context context)
                throws IOException, InterruptedException {

            double temp = 0;
            double dew = 0;
            double wind = 0;

            int count = 0;

            for (Text val : values) {

                String[] parts =
                        val.toString().split(",");

                temp += Double.parseDouble(parts[0]);
                dew += Double.parseDouble(parts[1]);
                wind += Double.parseDouble(parts[2]);

                count++;
            }

            context.write(
                    new Text("Average Temperature"),
                    new DoubleWritable(temp / count));

            context.write(
                    new Text("Average Dew Point"),
                    new DoubleWritable(dew / count));

            context.write(
                    new Text("Average Wind Speed"),
                    new DoubleWritable(wind / count));
        }
    }

    public static void main(String[] args)
            throws Exception {

        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf,
                "weather analysis");

        job.setJarByClass(WeatherAnalysis.class);

        job.setMapperClass(WeatherMapper.class);
        job.setReducerClass(WeatherReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job,
                new Path(args[0]));

        FileOutputFormat.setOutputPath(job,
                new Path(args[1]));

        System.exit(job.waitForCompletion(true)
                ? 0 : 1);
    }
}