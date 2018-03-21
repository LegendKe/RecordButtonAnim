package com.example.kechuanqi.recordbuttonanim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean isChecked;
    private ImageView iv_record;
    private ImageView iv_ring;
    private TextView tv_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_record = (ImageView) findViewById(R.id.iv_record);
        iv_ring = ((ImageView) findViewById(R.id.iv_ring));
        tv_hint = (TextView)findViewById(R.id.tv_hint);

        iv_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked = !isChecked;
                final int[] stateSet = {android.R.attr.state_checked * (isChecked ? 1 : -1)};
                iv_record.setImageState(stateSet,true);
                if(isChecked){
                    iv_ring.setImageResource(R.drawable.shape_ring_red);
                    tv_hint.setText(getString(R.string.recording));
                    tv_hint.setTextColor(getResources().getColor(R.color.colorAccent));
                    // TODO: 2018/3/21  录音
                }else {
                    iv_ring.setImageResource(R.drawable.shape_ring_white);
                    tv_hint.setText(getString(R.string.record_meeting));
                    tv_hint.setTextColor(getResources().getColor(R.color.colorWhite));
                }
            }
        });
    }
}
