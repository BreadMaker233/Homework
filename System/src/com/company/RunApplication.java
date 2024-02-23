package com.company;

import java.util.Scanner;

public class RunApplication {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        System.out.println("---------Welcome Student Management System----------");

        Scanner input = new Scanner(System.in);
        System.out.print("请输入学生的学号:");
        String stuId = input.nextLine();
        System.out.print("请输入课程代码:");
        String courseId = input.nextLine();

        int score = StudentService.search(stuId,courseId);

        if (score == -1) {
            System.out.println("信息错误");
        } else {
            System.out.println("该学生的成绩是" + score);
        }

    }
}
