package com.example.michele.michelelacorteelasticprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

import it.michelelacorteelasticprogressbar.R;

/**
 * Edited by michelelacorte on 27/10/15.
 */
public class ElasticDownloadView extends FrameLayout implements IntroView.EnterAnimationListener {

    private static final String LOG_TAG = ElasticDownloadView.class.getSimpleName();

    private IntroView mIntroView;
    private ProgressDownloadView mProgressDownloadView;
    private int mBackgroundColor;
    private boolean isAnimationFinished = false;
    private boolean isBackgroundColorSet = false;
    private int mBackgroundColorSet;

    /**
     * MARK: Constructor
     */

    public ElasticDownloadView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if(isBackgroundColorSet) {
            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.ColorOptionsView, 0, 0);
            mBackgroundColor = a.getColor(R.styleable.ColorOptionsView_backgroundColor,
                    mBackgroundColorSet);
        }
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_elasticdownload, this, true);
    }

    /**
     * MARK: Overrides
     */

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mIntroView = (IntroView) findViewById(R.id.intro_view);
        mIntroView.setListener(this);
        mProgressDownloadView = (ProgressDownloadView) findViewById(R.id.progress_download_view);

        ViewTreeObserver vto = mProgressDownloadView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    mProgressDownloadView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    mProgressDownloadView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                mIntroView.getLayoutParams().width = mProgressDownloadView.getWidth();
                mIntroView.getLayoutParams().height = mProgressDownloadView.getHeight();

                mProgressDownloadView.setBackgroundColor(mBackgroundColor);
            }
        });
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);

        mIntroView.init();
        mIntroView.setVisibility(VISIBLE);
    }

    /**
     * MARK: Public methods
     */

    public void startIntro() {
        mIntroView.startAnimation();
    }

    public void setProgress(float progress) {
        mProgressDownloadView.setPercentage(progress);
    }

    public void success() {
        mProgressDownloadView.drawSuccess();
    }

    public void fail() {
        mProgressDownloadView.drawFail();
    }


    /**
     * MARK: Enter animation overrides
     */

    public boolean isAnimationFinished()
    {
        return isAnimationFinished;
    }

    public void setColorBackground(int color)
    {
        mBackgroundColorSet = color;
        isBackgroundColorSet = true;
    }

    public int getColorBackground()
    {
        return mBackgroundColorSet;
    }

    @Override
    public void onEnterAnimationFinished() {
        mIntroView.setVisibility(INVISIBLE);
        mProgressDownloadView.setVisibility(VISIBLE);
        mProgressDownloadView.setProgress(mProgressDownloadView.getProgress());
        isAnimationFinished = true;

        // Do further actions if necessary
    }

}
