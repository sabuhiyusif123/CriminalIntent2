package criminalintent.android.bignerdranch.com.criminalintent;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Cavid on 4/24/2016.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private boolean mSolved;
    private Date mDate;

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public Crime(){
        //Generate Unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();

    }
    @Override
    public String toString(){
        return  mTitle;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
