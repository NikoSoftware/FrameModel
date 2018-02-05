package com.example.niko.framemodel.net;

/**
 * Created by niko on 2017/11/6.
 */

public class ProgressBean {

    private Long mTotal;
    private Long mProgress;


    public Long getmTotal() {
        return mTotal;
    }

    public void setmTotal(Long mTotal) {
        this.mTotal = mTotal;
    }

    public Long getmProgress() {
        return mProgress;
    }

    public void setmProgress(Long mProgress) {
        this.mProgress = mProgress;
    }

    @Override
    public String toString() {
        return "ProcessBean{" +
                "mTotal=" + mTotal +
                ", mProgress=" + mProgress +
                '}';
    }
}
