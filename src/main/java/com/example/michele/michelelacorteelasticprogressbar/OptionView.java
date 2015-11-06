package com.example.michele.michelelacorteelasticprogressbar;


/**
 * Created by Michele on 02/11/2015.
 */
public class OptionView {

    public static boolean isBackgroundColorSquareSet = false;
    public static boolean isColorSuccessSet = false;
    public static boolean isColorFailSet = false;
    public static boolean isColorProgressBarSet = false;
    public static boolean isColorProgressBarTextSet = false;
    public static boolean isColorProgressBarInProgressSet = false;
    public static boolean isColorCloudSet = false;
    public static boolean noBackground = false;
    private static int mColorCloud;
    private static int mColorProgressBarInProgress;
    private static int mColorProgressBarText;
    private static int mColorProgressBar;
    private static int mBackgroundColorSquare;
    private static int mColorSuccess;
    private static int mColorFail;

    public static void setBackgroundColorSquare(int color)
    {
        mBackgroundColorSquare = color;
        isBackgroundColorSquareSet = true;
    }

    public static int getColorBackgroundSquare()
    {
        return mBackgroundColorSquare;
    }


    public static void setColorSuccess(int color)
    {
        mColorSuccess = color;
        isColorSuccessSet = true;
    }

    public static int getColorSuccess()
    {
        return mColorSuccess;
    }

    public static void setColorFail(int color)
    {
        mColorFail = color;
        isColorFailSet = true;
    }

    public static int getColorFail()
    {
        return mColorFail;
    }

    public static void setColorProgressBar(int color)
    {
        mColorProgressBar = color;
        isColorProgressBarSet = true;
    }

    public static int getColorProgressBar()
    {
        return mColorProgressBar;
    }

    public static void setColorProgressBarText(int color)
    {
        mColorProgressBarText = color;
        isColorProgressBarTextSet = true;
    }

    public static int getColorProgressBarText()
    {
        return mColorProgressBarText;
    }

    public static void setColorProgressBarInProgress(int color)
    {
        mColorProgressBarInProgress = color;
        isColorProgressBarInProgressSet = true;
    }

    public static int getColorProgressBarInProgress()
    {
        return mColorProgressBarInProgress;
    }

    public static void setColorCloud(int color)
    {
        mColorCloud = color;
        isColorCloudSet = true;
    }

    public static int getColorCloud()
    {
        return mColorCloud;
    }
}
