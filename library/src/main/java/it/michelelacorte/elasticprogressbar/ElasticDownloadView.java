package it.michelelacorte.elasticprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;


/**
 * Edited by michelelacorte on 27/10/15.
 */
public class ElasticDownloadView extends FrameLayout implements IntroView.EnterAnimationListener {

    private static final String LOG_TAG = ElasticDownloadView.class.getSimpleName();

    private IntroView mIntroView;
    private ProgressDownloadView mProgressDownloadView;
    private int mBackgroundColor;
    private boolean isAnimationFinished = false;
    private float mProgress;

    /**
     * MARK: Constructor
     */

    public ElasticDownloadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(OptionView.isBackgroundColorSquareSet) {
            TypedArray a = context.obtainStyledAttributes(attrs,
                    R.styleable.ColorOptionsView, 0, 0);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                mBackgroundColor = a.getColor(R.styleable.ColorOptionsView_backgroundColor,
                        ContextCompat.getColor(context, OptionView.getColorBackgroundSquare()));
            }else {
                mBackgroundColor = a.getColor(R.styleable.ColorOptionsView_backgroundColor,
                        getResources().getColor(OptionView.getColorBackgroundSquare()));
            }
            a.recycle();
        }
        else {
            if(!OptionView.noBackground) {
                TypedArray a = context.obtainStyledAttributes(attrs,
                        R.styleable.ColorOptionsView, 0, 0);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mBackgroundColor = a.getColor(R.styleable.ColorOptionsView_backgroundColor,
                            ContextCompat.getColor(context, R.color.colorPrimary));
                } else {
                    mBackgroundColor = a.getColor(R.styleable.ColorOptionsView_backgroundColor,
                            getResources().getColor(R.color.colorPrimary));
                }
                a.recycle();
            }
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
        if(OptionView.isColorSuccessSet) {
            mProgressDownloadView.setColorSuccess(OptionView.getColorSuccess());
        }else
        {
            mProgressDownloadView.setColorSuccess(R.color.colorPrimary);
        }
        if(OptionView.isColorFailSet) {
            mProgressDownloadView.setColorFail(OptionView.getColorFail());
        }else
        {
            mProgressDownloadView.setColorFail(R.color.colorPrimary);
        }
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
        if(OptionView.noIntro) {
            mIntroView.setVisibility(INVISIBLE);
            mProgressDownloadView.setVisibility(VISIBLE);
        }
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

    public float getProgress() {
        return mProgress;
    }

    public void startIntro() {
        mIntroView.startAnimation();
    }

    public void setProgress(float progress) {
        mProgressDownloadView.setPercentage(progress);
        mProgress = progress;
    }

    public void success() {
        mProgressDownloadView.drawSuccess();
    }

    public void fail() {
        mProgressDownloadView.drawFail();
    }

    public boolean isAnimationFinished()
    {
        return isAnimationFinished;
    }

    /**
     * MARK: Enter animation overrides
     */


    @Override
    public void onEnterAnimationFinished() {
        mIntroView.setVisibility(INVISIBLE);
        mProgressDownloadView.setVisibility(VISIBLE);
        mProgressDownloadView.setProgress(mProgressDownloadView.getProgress());
        isAnimationFinished = true;

        // Do further actions if necessary
    }

}
