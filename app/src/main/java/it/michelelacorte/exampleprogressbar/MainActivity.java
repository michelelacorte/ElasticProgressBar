package it.michelelacorte.exampleprogressbar;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import it.michelelacorte.elasticprogressbar.OptionView;
import it.michelelacorte.exampleprogressbar.R;

import it.michelelacorte.elasticprogressbar.ElasticDownloadView;


public class MainActivity extends AppCompatActivity {
    ElasticDownloadView mElasticDownloadView;
    CoordinatorLayout mCoordinatorLayout;
    FloatingActionButton fabStart;
    FloatingActionButton fabCancel;

    /*

   Fake download file

     */
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private long fileSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*

        VARIOUS OPTION

         */
        //OptionView.setBackgroundColorSquare(R.color.blue);
        //OptionView.noBackground = true;
        //OptionView.setColorCloud(R.color.red);
        //OptionView.setColorProgressBar(R.color.red);
        //OptionView.setColorProgressBarInProgress(R.color.darkblue);
        //OptionView.setColorProgressBarText(R.color.darkblue);
        //OptionView.setColorSuccess(R.color.darkblue);
        //OptionView.setColorFail(R.color.orange);
        //OptionView.noIntro = true;

        setContentView(R.layout.activity_main);
        mElasticDownloadView = (ElasticDownloadView)findViewById(R.id.elastic_download_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mCoordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        mElasticDownloadView = (ElasticDownloadView)findViewById(R.id.elastic_download_view);
        fabStart = (FloatingActionButton) findViewById(R.id.fabStart);
        fabCancel = (FloatingActionButton) findViewById(R.id.fabCancel);
        fabCancel.setVisibility(View.INVISIBLE);

        fabCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mCoordinatorLayout, "Progress Bar Reloaded!", Snackbar.LENGTH_LONG).show();
                mElasticDownloadView.setProgress(0);
                fabCancel.setVisibility(View.INVISIBLE);
                fabStart.setVisibility(View.VISIBLE);
            }
        });

        fabStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mCoordinatorLayout, "Progress Bar Started!", Snackbar.LENGTH_LONG).show();
                mElasticDownloadView.startIntro();
                fabCancel.setVisibility(View.VISIBLE);
                fabStart.setVisibility(View.INVISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus = downloadFile();
                            handler.post(new Runnable() {
                                public void run() {
                                    //Set progress dinamically
                                    mElasticDownloadView.setProgress(progressStatus);
                                    Log.d("Progress:", "" + mElasticDownloadView.getProgress());
                                }
                            });
                        }
                        if (progressStatus >= 100) {
                            mElasticDownloadView.success();
                        }
                    }
                }, 1000);
            }
        });

    }


    //Fake download file example
    public int downloadFile() {

        while (fileSize <= 1000000) {

            fileSize++;

            if (fileSize == 100000) {
                return 10;

            } else if (fileSize == 200000) {
                return 20;

            } else if (fileSize == 300000) {
                return 30;

            } else if (fileSize == 400000) {
                return 40;

            } else if (fileSize == 500000) {

                return 50;
            } else if (fileSize == 700000) {

                return 70;
            } else if (fileSize == 800000) {

                return 80;
            } else if (fileSize == 900000) {

            return 90;
            }
        }

        return 100;

    }
}
