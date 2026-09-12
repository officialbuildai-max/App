package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.TextView;
import j00.b;

/* loaded from: classes.dex */
public class SimplePagerTitleView extends TextView implements b {

    /* renamed from: a, reason: collision with root package name */
    protected int f70543a;

    /* renamed from: b, reason: collision with root package name */
    protected int f70544b;

    public SimplePagerTitleView(Context context) {
        super(context, null);
        a(context);
    }

    private void a(Context context) {
        setGravity(17);
        int a11 = i00.b.a(context, 10.0d);
        setPadding(a11, 0, a11, 0);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // j00.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // j00.b
    public int getContentLeft() {
        String charSequence;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // j00.b
    public int getContentRight() {
        String charSequence;
        Rect rect = new Rect();
        if (getText().toString().contains("\n")) {
            charSequence = "";
            for (String str : getText().toString().split("\\n")) {
                if (str.length() > charSequence.length()) {
                    charSequence = str;
                }
            }
        } else {
            charSequence = getText().toString();
        }
        getPaint().getTextBounds(charSequence, 0, charSequence.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // j00.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public int getNormalColor() {
        return this.f70544b;
    }

    public int getSelectedColor() {
        return this.f70543a;
    }

    public void onDeselected(int i11, int i12) {
        setTextColor(this.f70544b);
    }

    public void onEnter(int i11, int i12, float f11, boolean z10) {
    }

    public void onLeave(int i11, int i12, float f11, boolean z10) {
    }

    public void onSelected(int i11, int i12) {
        setTextColor(this.f70543a);
    }

    public void setNormalColor(int i11) {
        this.f70544b = i11;
    }

    public void setSelectedColor(int i11) {
        this.f70543a = i11;
    }
}
