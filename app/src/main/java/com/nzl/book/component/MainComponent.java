package com.nzl.book.component;

import com.nzl.book.ui.activity.MainActivity;
import com.nzl.book.ui.fragment.FindFragment;
import com.nzl.book.ui.fragment.HomeFragment;

import dagger.Component;

/**
 * Created by Administrator on 2016/11/7.
 */
@Component(dependencies = AppComponent.class)
public interface MainComponent {

    MainActivity inject(MainActivity activity);

    HomeFragment inject(HomeFragment homeFragment);

    FindFragment inject(FindFragment findFragment);

}
