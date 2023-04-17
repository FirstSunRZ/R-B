package com.lucky.randb.controller;

import com.lucky.randb.entity.ResultNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XingYu.Zheng
 * @date 2023/4/17 13:58
 */
@RestController
@RequestMapping("/number")
public class NumberController {

    private static final int LUCKY_RED = 6;
    private static final int LUCKY_BLUE = 1;
    private static final int HAPPY_RED = 5;
    private static final int HAPPY_BLUE = 2;
    private static final int SIZE = 1;


    @GetMapping(path = {"/lucky/{red}/{blue}/{size}","/lucky/{red}/{blue}", "/lucky/{size}", "/lucky"})
    public String lucky(@PathVariable(required = false) Integer red, @PathVariable(required = false) Integer blue, @PathVariable(required = false) Integer size) {
        if (red == null) {
            red = LUCKY_RED;
        }
        if (blue == null) {
            blue = LUCKY_BLUE;
        }
        if (size == null) {
            size = SIZE;
        }
        //创建一个list，用来存放结果
        List<ResultNumber> resultList = new ArrayList<>();
        //取size组红球和蓝球
        for (int i = 0; i < size; i++) {
            //创建一个list，用来存放红球
            List<String> redList = new ArrayList<>();
            List<Integer> reds = new ArrayList<>();
            //创建一个list，用来存放蓝球
            List<String> blueList = new ArrayList<>();
            List<Integer> blues = new ArrayList<>();
            //从1-33中随机取red个不重复的数,并放入redList,并且去重,并且排序,并且转换为String
            for (int j = 0; j < red; j++) {
                //随机取一个数
                int random = (int) (Math.random() * 33 + 1);
                //将随机取的数放入redList
                reds.add(random);
                //去重,并且排序,并且转换为String,补0
                redList = reds.stream().distinct().sorted().map(String::valueOf).map(s -> {
                    if (s.length() == 1) {
                        return "0" + s;
                    }
                    return s;
                }).collect(Collectors.toList());
                //如果去重后的集合长度小于red,则继续取数
                if (redList.size() < red) {
                    j--;
                }
                //如果去重后的集合长度等于red,则跳出循环
                if (redList.size() == red) {
                    break;
                }
                //如果去重后的集合长度大于red,则抛出异常
                if (redList.size() > red) {
                    throw new RuntimeException("取红球出错");
                }
            }
            //从1-16中随机取blue个不重复的数,并放入blueList,并且去重,并且排序,并且转换为String
            for (int j = 0; j < blue; j++) {
                //随机取一个数
                int random = (int) (Math.random() * 16 + 1);
                //将随机取的数放入blueList
                blues.add(random);
                //去重,并且排序,并且转换为String,补0
                blueList = blues.stream().distinct().sorted().map(String::valueOf).map(s -> {
                    if (s.length() == 1) {
                        return "0" + s;
                    }
                    return s;
                }).collect(Collectors.toList());
                //如果去重后的集合长度小于blue,则继续取数
                if (blueList.size() < blue) {
                    j--;
                }
                //如果去重后的集合长度等于blue,则跳出循环
                if (blueList.size() == blue) {
                    break;
                }
                //如果去重后的集合长度大于blue,则抛出异常
                if (blueList.size() > blue) {
                    throw new RuntimeException("取蓝球出错");
                }
            }
            //将红球和蓝球放入结果集
            resultList.add(new ResultNumber(redList, blueList));
        }
        //打印结果
        for (ResultNumber resultNumber : resultList) {
            System.out.println(resultNumber);
        }
        //返回结果
        return resultList.toString();
    }

    @GetMapping(path = {"/happy/{red}/{blue}/{size}","/happy/{red}/{blue}", "/happy/{size}", "/happy"})
    public String happy(@PathVariable(required = false) Integer red, @PathVariable(required = false) Integer blue, @PathVariable(required = false) Integer size) {
        if (red == null) {
            red = HAPPY_RED;
        }
        if (blue == null) {
            blue = HAPPY_BLUE;
        }
        if (size == null) {
            size = SIZE;
        }
        //创建一个list，用来存放结果
        List<ResultNumber> resultList = new ArrayList<>();
        //取size组红球和蓝球
        for (int i = 0; i < size; i++) {
            //创建一个list，用来存放红球
            List<String> redList = new ArrayList<>();
            List<Integer> reds = new ArrayList<>();
            //创建一个list，用来存放蓝球
            List<String> blueList = new ArrayList<>();
            List<Integer> blues = new ArrayList<>();
            //从1-35中随机取red个不重复的数,并放入redList,并且去重,并且排序,并且转换为String
            for (int j = 0; j < red; j++) {
                //随机取一个数
                int random = (int) (Math.random() * 35 + 1);
                //将随机取的数放入redList
                reds.add(random);
                //去重,并且排序,并且转换为String,补0
                redList = reds.stream().distinct().sorted().map(String::valueOf).map(s -> {
                    if (s.length() == 1) {
                        return "0" + s;
                    }
                    return s;
                }).collect(Collectors.toList());
                //如果去重后的集合长度小于red,则继续取数
                if (redList.size() < red) {
                    j--;
                }
                //如果去重后的集合长度等于red,则跳出循环
                if (redList.size() == red) {
                    break;
                }
                //如果去重后的集合长度大于red,则抛出异常
                if (redList.size() > red) {
                    throw new RuntimeException("取红球出错");
                }
            }
            //从1-12中随机取blue个不重复的数,并放入blueList,并且去重,并且排序,并且转换为String
            for (int j = 0; j < blue; j++) {
                //随机取一个数
                int random = (int) (Math.random() * 12 + 1);
                //将随机取的数放入blueList
                blues.add(random);
                //去重,并且排序,并且转换为String,补0
                blueList = blues.stream().distinct().sorted().map(String::valueOf).map(s -> {
                    if (s.length() == 1) {
                        return "0" + s;
                    }
                    return s;
                }).collect(Collectors.toList());
                //如果去重后的集合长度小于blue,则继续取数
                if (blueList.size() < blue) {
                    j--;
                }
                //如果去重后的集合长度等于blue,则跳出循环
                if (blueList.size() == blue) {
                    break;
                }
                //如果去重后的集合长度大于blue,则抛出异常
                if (blueList.size() > blue) {
                    throw new RuntimeException("取蓝球出错");
                }
            }
            //将红球和蓝球放入结果集
            resultList.add(new ResultNumber(redList, blueList));
        }
        //打印结果
        for (ResultNumber resultNumber : resultList) {
            System.out.println(resultNumber);
        }
        //返回结果
        return resultList.toString();
    }

}
