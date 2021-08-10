package sangil.BOJ_10825_KEM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static class Student implements Comparable<Student>{
		String name;
		int korean;
		int english;
		int math;
		
		public Student(String name, int korean, int english, int math) {
			super();
			this.name = name;
			this.korean = korean;
			this.english = english;
			this.math = math;
		}

		public String getName() {
			return name;
		}

		public int getKorean() {
			return korean;
		}

		public int getEnglish() {
			return english;
		}

		public int getMath() {
			return math;
		}

		@Override
		public int compareTo(Student o) {
			if(this.korean == o.korean) {
				if(this.english == o.english) {
					if(this.math == o.math) {
						return this.name.compareTo(o.name);
					}
					return o.math - this.math;
				}
				return this.english - o.english;
			}
			return o.korean - this.korean;
		}
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<Student> students = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			students.add(new Student(st.nextToken(), 
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()))
					);
		}
		
		// Comparator 사용
//		students.sort(Comparator.comparing(Student::getKorean).reversed()
//				.thenComparing(Student::getEnglish)
//				.thenComparing(Comparator.comparing(Student::getMath).reversed())
//				.thenComparing(Student::getName));
		
		// Comparable compareTo 사용
		students.sort(null);
						
		StringBuilder sb = new StringBuilder();
		for(Student s : students) {
			sb.append(s.getName()).append("\n");
		}
		System.out.println(sb);
	}	
	
}

