package com.transsion.publish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/* loaded from: classes6.dex */
public class MatchParentVideoView extends VideoView {

    /* renamed from: a, reason: collision with root package name */
    private int f50699a;

    /* renamed from: b, reason: collision with root package name */
    private int f50700b;

    /* renamed from: c, reason: collision with root package name */
    private int f50701c;

    /* renamed from: d, reason: collision with root package name */
    private int f50702d;

    /* renamed from: e, reason: collision with root package name */
    private int f50703e;

    public MatchParentVideoView(Context context) {
        this(context, null);
    }

    public MatchParentVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MatchParentVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f50699a = 0;
        this.f50700b = 0;
        this.f50701c = 0;
        this.f50702d = 0;
        this.f50703e = 0;
    }

    public int getVideoHeight() {
        return this.f50700b;
    }

    public int getVideoWidth() {
        return this.f50699a;
    }

    @Override // android.widget.VideoView
    public void setVideoPath(String str) {
        super.setVideoPath(str);
    }
}
