package day04;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SignUpInShell {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Account> members = new ArrayList<>();

    public static void main(String[] args) {
        int menuNo;
        while (true) {
            System.out.println("JH World 에 오신것을 환영합니다. 아래에서 메뉴를 선택하세요.");
            System.out.print("1.회원가입\n2.로그인\n0.종료\n>> ");

            menuNo = scanner.nextInt();

            switch (menuNo) {
                case 0:
                    return;
                case 1:
                    join();
                    break;
                case 2:
                    login();
                    break;
            }
        }
    }

    private static void login() {
        scanner.nextLine();

        System.out.println("-----------------------------------");
        System.out.println("로그인 해주세요.");

        System.out.print("아이디 >");
        String id = scanner.nextLine();
        System.out.print("패스워드 >");
        String password = scanner.nextLine();

        Account account = findById(id);

        if (Objects.isNull(account)) {
            System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
            return;
        }

        if (!account.isAdmin && account.failCount == 2) {
            System.out.println("해당 계정은 잠겼습니다.");
            return;
        }

        if (!Objects.equals(account.password, password)) {
            System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
            increaseFailCount(id);
            return;
        }

        System.out.println(account.name + "님 환영합니다.");
        System.exit(0);
    }

    private static void increaseFailCount(String id) {
        Account account = findById(id);
        if (Objects.requireNonNull(account).isAdmin) return;
        account.failCount++;
    }

    private static Account findById(String id) {
        for (Account account : members) {
            if (Objects.equals(account.id, id)) {
                return account;
            }
        }
        return null;
    }

    private static boolean join() {
        scanner.nextLine();

        System.out.println("-----------------------------------");
        System.out.println("회원가입을 해주세요.");

        System.out.print("아이디 > ");
        String id = scanner.nextLine();

        System.out.print("비밀번호 > ");
        String password = scanner.nextLine();

        System.out.print("비밀번호 재입력 > ");
        String rePassword = scanner.nextLine();

        System.out.print("이름 > ");
        String name = scanner.nextLine();

        System.out.print("권한(1:관리자, 2:일반) > ");
        int authority = scanner.nextInt();

        if (Objects.equals(id, "") || Objects.equals(password, "") || Objects.equals(rePassword, "")
            || Objects.equals(name, "")) {
            System.out.println("회원가입에 실패했습니다. (입력항목 중 공백이 존재합니다.)");
            return false;
        }

        if (!Objects.equals(password, rePassword)) {
            System.out.println("회원가입에 실패했습니다. (비밀번호 불일치.)");
            return false;
        }

        if (authority == 1) {
            members.add(new Admin(id, password, name));
        } else if (authority == 2) {
            members.add(new User(id, password, name));
        } else {
            System.out.println("권한에는 1 또는 2 의 숫자만 입력가능합니다.");
            return false;
        }

        System.out.println("회원가입에 성공했습니다. 이전메뉴로 돌아갑니다.");
        return true;
    }
}