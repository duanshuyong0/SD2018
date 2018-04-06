package com.loonxi.channel.facebook.model;

/**
 * Created by xyy on 2017/1/8.
 */
public class FBCursorMode {
        /**
         * 上一页或者下一页的地址
         */
        private String value;

        /**
         * 表示上一页或者下一页
         */
        private FBCursorDirection cursorDirection;


        public FBCursorMode(String value, FBCursorDirection cursorDirection) {
                this.value = value;
                this.cursorDirection = cursorDirection;
        }

        public String getValue() {
                return value;
        }

        public FBCursorDirection getCursorDirection() {
                return cursorDirection;
        }
}
