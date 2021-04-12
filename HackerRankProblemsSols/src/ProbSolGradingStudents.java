	import java.io.*;
	import java.math.*;
	import java.security.*;
	import java.text.*;
	import java.util.*;
	import java.util.concurrent.*;
	import java.util.function.*;
	import java.util.regex.*;
	import java.util.stream.*;
	import static java.util.stream.Collectors.joining;
	import static java.util.stream.Collectors.toList;
	class Result {n
	public static List<Integer> gradingStudents(List<Integer> grades) {
	    // Write your code here
	        for(int i = 0 ; i < grades.size(); i++){
	            int grade = grades.get(i);
	            if(grade>=38 && grade%5 != 0){
	                int newGrade = grade;
	                for(int j = 0 ; j <2; j++){
	                    newGrade++;
	                    if(newGrade%5 == 0)    {grade = newGrade;   break;}
	                }
	            grades.set(i,grade);
	            }
	        }
	        return grades;
	    }

	}

	public class ProbSolGradingStudents {
	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

	        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
	            try {
	                return bufferedReader.readLine().replaceAll("\\s+$", "");
	            } catch (IOException ex) {
	                throw new RuntimeException(ex);
	            }
	        })
	            .map(String::trim)
	            .map(Integer::parseInt)
	            .collect(toList());

	        List<Integer> result = Result.gradingStudents(grades);

	        bufferedWriter.write(
	            result.stream()
	                .map(Object::toString)
	                .collect(joining("\n"))
	            + "\n"
	        );

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
}
