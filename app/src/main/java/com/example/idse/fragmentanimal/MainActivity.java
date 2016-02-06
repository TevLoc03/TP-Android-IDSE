package com.example.idse.fragmentanimal;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity implements Tab1Fragment.DataTransmit {

    private PageAdapter pageAdapter;
    private ViewPager viewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(pageAdapter);

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setShouldExpand(true);
        tabs.setViewPager(viewPager);

		/*ActionBar actionBar=getActionBar();

		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		String label1 = "tab1";
		Tab tab = actionBar.newTab();
		tab.setText(label1);
		TabListener<Tab1Fragment> t1 = new TabListener<Tab1Fragment>(this, label1, Tab1Fragment.class);
		tab.setTabListener(t1);
		actionBar.addTab(tab);
		
		String label2 = "tab";
		tab = actionBar.newTab();
		tab.setText(label2);
		TabListener<Tab2Fragment> t2 = new TabListener<Tab2Fragment>(this, label2, Tab2Fragment.class);
		tab.setTabListener(t2);
		actionBar.addTab(tab);*/

		
	}

    @Override
    public void transmit(String data) {
        Tab2Fragment tab2Fragment=(Tab2Fragment) pageAdapter.getItem(1);
        tab2Fragment.changeData(data);
    }


    private class TabListener<T extends Fragment> implements ActionBar.TabListener {

		private Fragment mFragment;
		private final FragmentActivity mActivity;
		private final String mTag;
		private final Class<T> mClass;
		
		public TabListener(FragmentActivity activity, String tag, Class<T> clz) {
			mActivity = activity;
			mTag = tag;
			mClass = clz;
		}

        @Override
        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub
            if(mFragment == null)
            {
                mFragment = Fragment.instantiate(mActivity, mClass.getName());
                ft.add(android.R.id.content, mFragment, mTag);
            } else {
                ft.attach(mFragment);
            }
        }

        @Override
        public void onTabUnselected(Tab tab, FragmentTransaction ft) {
            // TODO Auto-generated method stub
            if(mFragment != null)
            {
                ft.detach(mFragment);
            }
        }

        @Override
        public void onTabReselected(Tab tab, FragmentTransaction ft) {

        }
    }
}
