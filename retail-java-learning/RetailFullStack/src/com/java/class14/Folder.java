package com.java.class14;

import java.io.File;
import java.nio.file.Paths;

public class Folder {
    public static void main(String[] args) {
        String directoryPath = Paths.get("C:", "Users", "GAHUI", "Documents", "test").toString();
 
        listFolderStructure(directoryPath, 0);
    }

    public static void listFolderStructure(String directoryPath, int depth) {
        File directory = new File(directoryPath);

        // 디렉토리가 존재하지 않으면 종료
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }

        // 현재 디렉토리 이름 출력
        System.out.println(getIndent(depth) + directory.getName() + " (Dir)");

        // 디렉토리 내 파일 및 하위 디렉토리를 재귀적으로 출력
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFolderStructure(file.getAbsolutePath(), depth + 1);
                } else {
                    System.out.println(getIndent(depth + 1) + file.getName());
                }
            }
        }
    }

    public static String getIndent(int depth) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indent.append("  "); // 들여쓰기 스페이스
        }
        return indent.toString();
    }
}