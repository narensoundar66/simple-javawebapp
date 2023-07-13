package com.vlavik.homework.data;

import java.util.List;

public interface ObjectContainer {

    List<? extends Object> getList();

    List<? extends Object> getOne();

    List<? extends Object> postOne();

    List<? extends Object> putOne();

    List<? extends Object> deleteOne();

    int getSize();
}
