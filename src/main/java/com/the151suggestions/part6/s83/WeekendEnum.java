package com.the151suggestions.part6.s83;

/**
 * 枚举用法4:实现接口并覆写接口方法
 * Created by ankang on 2017-08-14.
 */
public enum WeekendEnum implements Subject{
    MONDAY {
        @Override
        public void dealTask() {

        }
    }, TUESDAY {
        @Override
        public void dealTask() {

        }
    }, WEDNESDAY {
        @Override
        public void dealTask() {

        }
    }, THURSDAY {
        @Override
        public void dealTask() {

        }
    }, FRIDAY {
        @Override
        public void dealTask() {

        }
    }, SATURDAY {
        @Override
        public void dealTask() {

        }
    }, SUNDAY {
        @Override
        public void dealTask() {

        }
    }
}
