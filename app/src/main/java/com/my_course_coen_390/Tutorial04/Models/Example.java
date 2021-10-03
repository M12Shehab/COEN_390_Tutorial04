package com.my_course_coen_390.Tutorial04.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("main")
    Main main;
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
