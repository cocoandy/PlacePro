package com.wulias.project.weight;

import android.app.Activity;

/**
 * Created by llm on 2017/2/17.
 */

public class ImageDialog extends Activity {
//    @BindView(R.id.mvp_dialog_image)
//    MyViewPager mMvpDialog;
//    @Bind(R.id.ll_dots_dialog_Image)
//    LinearLayout mLlDots;
//
//    private List<String> urls;// 图片地址
//    private List<ImageView> imgs;// 图片显示控件
//    private int current;// 当前选中图片的索引
//    private int type;//0 带地址的图片 1 二维码
//    private boolean flag;//是否带点
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_image);
//        ButterKnife.bind(this);
//        setTitle("");
//        init();
//    }
//
//
//    private void init() {
//        initData();
//
//        mMvpDialog.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return urls.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view == object;
//            }
//
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                ImageView imageView = imgs.get(position);
//                mMvpDialog.addView(imageView);
//                return imageView;
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                container.removeView((View) object);
//            }
//        });
//        mMvpDialog.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                mLlDots.getChildAt(position).setSelected(true);
//                mLlDots.getChildAt(current).setSelected(false);
//                current = position;
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        // 选中点击的图片
//        mMvpDialog.setCurrentItem(current);
//        if (!flag) {
//            mLlDots.getChildAt(current).setSelected(true);
//        }
//    }
//
//    private void initData() {
//        Intent intent = getIntent();
//        urls = intent.getStringArrayListExtra("urls");
//        current = intent.getIntExtra("position", 0);
//        flag = intent.getBooleanExtra("flag", false);
//        type = intent.getIntExtra("type", 0);
//
//        ImageView imageView;
//        View view;
//        LinearLayout.LayoutParams paramsDots = new LinearLayout.LayoutParams(UIUtils.dp2Px(10), UIUtils.dp2Px(10));
//        imgs = new ArrayList<>();
//        for (int i = 0; i < urls.size(); i++) {
//            imageView = new ImageView(mContext);
//            switch (type) {
//                case 0:
//                    GlideUtil.getInstance().ImageLoad(mContext, urls.get(i), 0, imageView);
//                    break;
//                case 1:
//                    int w = DeviceUtil.getScreenWidth(mContext) * 4 / 5;
//                    imageView.setImageBitmap(ZXingUtils.Create2DCode(urls.get(i), w, w));
//                    break;
//
//            }
//            if (!flag) {
//                view = new View(mContext);
//                view.setBackgroundResource(R.drawable.selector_dots);
//                if (i != 0) {
//                    paramsDots.setMargins(UIUtils.dp2Px(8), 0, 0, 0);
//                }
//                view.setLayoutParams(paramsDots);
//                mLlDots.addView(view);
//            }
//
//            imgs.add(imageView);
//
//        }
//    }
//
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        ButterKnife.unbind(this);
//    }
}
