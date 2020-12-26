/*
 * Copyright (c) 2020 Altus Group. All Rights Reserved.
 */
package ad4;

import util.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class main {

    private static Pattern pidPattern = Pattern.compile("pid:\\d{9}");
    private static Pattern hclPattern = Pattern.compile("hcl:\\#[a-f\\d]{6}");
    private static Pattern hgtPattern = Pattern.compile("hgt:((1[5-8]\\d|19[0-3])cm|(59|6\\d|7[0-6])in)");
    private static Pattern eclPattern = Pattern.compile("ecl:(amb|blu|brn|gry|grn|hzl|oth)");
    private static Pattern eyrPattern = Pattern.compile("eyr:(202\\d|2030)");
    private static Pattern iyrPattern = Pattern.compile("iyr:(201\\d|2020)");
    private static Pattern byrPattern = Pattern.compile("byr:(19[2-9]\\d|200[0-2])");

    public static void main(String[] args) {
        List<String> input = Helper.read("input4.txt");

        List<String> documents = createDocuments(input);
        int valid_passports = 0;

        for (String document : documents) {
//            System.out.print(document);
            try {
                if (validator(document)) {
                    valid_passports++;
                    System.out.print(document);
                    System.out.println(" true");
                } else {
                    System.out.print(document);
                    System.out.println("");
                }
            } catch (Exception e) {
            }
        }

        System.out.println("Valid passports are: " + valid_passports);
    }

    private static boolean validator(String document) {
        return pidPattern.matcher(document).find() && hclPattern.matcher(document).find() && hgtPattern.matcher(document).find() &&
                eclPattern.matcher(document).find() && eyrPattern.matcher(document).find() && iyrPattern.matcher(document).find() &&
                byrPattern.matcher(document).find();
    }

    private static boolean validation(String document) {
        Boolean valid = true;
//        if (document.contains("byr")) {
//            String byr = document.substring(document.indexOf("byr:") + 4, document.indexOf("byr:") + 8);
//            valid &= byrPattern.matcher(byr).find();
////            System.out.println("byr is " + byr + " is " + valid);
//        } else {
//            return false;
//        }
        valid &= byrPattern.matcher(document).find();
        valid &= iyrPattern.matcher(document).find();
//        if (document.contains("iyr")) {
//            String iyr = document.substring(document.indexOf("iyr:") + 4, document.indexOf("iyr:") + 8);
//            valid &= iyrPattern.matcher(iyr).find();
////            System.out.println("iyr is " + iyr + " is " + valid);
//        } else {
//            return false;
//        }
//        if (document.contains("eyr")) {
//            String eyr = document.substring(document.indexOf("eyr:") + 4, document.indexOf("eyr:") + 8);
//            valid &= eyrPattern.matcher(eyr).find();
////            System.out.println("iyr is " + eyr + " is " + valid);
//        } else {
//            return false;
//        }
        valid &= eyrPattern.matcher(document).find();
        valid &= pidPattern.matcher(document).find();
//        if (document.contains("pid")) {
//            String pid = document.substring(document.indexOf("pid:") + 4, document.indexOf("pid:") + 13);
//            valid &= pidPattern.matcher(pid).find();
////            System.out.println("pid is " + pid + " is " + valid);
//        } else {
//            return false;
//        }
//        if (document.contains("ecl")) {
//            String ecl = document.substring(document.indexOf("ecl:") + 4, document.indexOf("ecl:") + 7);
//            valid &= eclPattern.matcher(ecl).find();
////            System.out.println("ecl is " + ecl + " is " + valid);
//        } else {
//            return false;
//        }
        valid &= eclPattern.matcher(document).find();
        valid &= hclPattern.matcher(document).find();
//        if (document.contains("hcl")) {
//            String hcl = document.substring(document.indexOf("hcl:") + 4, document.indexOf("hcl:") + 11);
//            valid &= hclPattern.matcher(hcl).find();
////            System.out.println("hcl is " + hcl + " is " + valid);
//        } else {
//            return false;
//        }
//        if (document.contains("hgt")) {
//            String hgt = document.substring(document.indexOf("hgt:") + 4, document.indexOf("hgt:") + 9);
//            hgt = hgt.trim();
//            valid &= hgtPattern.matcher(hgt).find();
//        } else {
//            return false;
//        }
        valid &= hgtPattern.matcher(document).find();
        return valid;
    }

    private static List<String> createDocuments(List<String> input) {
        List<String> documents = new ArrayList<>();

        StringBuffer document = new StringBuffer("");
        for (String inputRow : input) {
            if (inputRow.isEmpty() || " ".equalsIgnoreCase(inputRow)) {
                documents.add(document.toString());
                document = new StringBuffer();
            } else {
                document.append(" ");
                document.append(inputRow);
            }
        }

        if (!document.toString().isEmpty())
            documents.add(document.toString());

        return documents;
    }
}
