package com.lucky.randb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author XingYu.Zheng
 * @date 2023/4/17 14:04
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ResultNumber implements Serializable {

    private List<String> red;
    private List<String> blue;

    @Override
    public String toString() {
        StringBuilder redStr = new StringBuilder();
        StringBuilder blueStr = new StringBuilder();
        for (String s : red) {
            redStr.append(s).append(" ");
        }
        for (String s : blue) {
            blueStr.append(s).append(" ");
        }
        return "红球：" + redStr + "蓝球：" + blueStr;
    }
}
