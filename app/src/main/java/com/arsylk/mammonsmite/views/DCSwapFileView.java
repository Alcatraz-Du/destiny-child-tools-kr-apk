package com.arsylk.mammonsmite.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.arsylk.mammonsmite.R;

import java.io.File;

public class DCSwapFileView extends LinearLayout {
    private File file;
    private boolean from;
    private TextView label;
    private View line;

    public DCSwapFileView(Context context, File file, boolean from) {
        super(context);
        this.file = file;
        this.from = from;
        initViews();
    }

    public DCSwapFileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    private void initViews() {
        addView(inflate(getContext(), R.layout.item_draglist, null));
        setTag(file);

        label = findViewById(R.id.label);
        label.setText(file.getName());

        line = findViewById(R.id.line);
    }
}
