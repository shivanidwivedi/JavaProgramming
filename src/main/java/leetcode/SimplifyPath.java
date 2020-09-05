package leetcode;

import java.util.Stack;

/**
 * @author shivanidwivedi on 05/09/20
 * @project JavaProgramming
 *
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 *
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level.
 *
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names.
 * The last directory name (if it exists) must not end with a trailing /.
 * Also, the canonical path must be the shortest string representing the absolute path.
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }

        Stack<String> stack = new Stack<>();
        String[] array = path.split("/");

        for (String str : array) {
            if (str.equals(".") || str.isEmpty()) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/");
            sb.append(str);
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }

    public static void main(String[] s) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
