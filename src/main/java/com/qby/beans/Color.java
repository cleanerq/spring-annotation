package com.qby.beans;

/**
 * 使用import导入组件
 * @author qby
 * @date 2020/6/9 17:39
 */
public class Color {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}
