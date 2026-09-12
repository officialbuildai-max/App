package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes4.dex */
class k extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private static final int f28940d;

    /* renamed from: a, reason: collision with root package name */
    private final Calendar f28941a;

    /* renamed from: b, reason: collision with root package name */
    private final int f28942b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28943c;

    static {
        f28940d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public k() {
        Calendar s11 = x.s();
        this.f28941a = s11;
        this.f28942b = s11.getMaximum(7);
        this.f28943c = s11.getFirstDayOfWeek();
    }

    public k(int i11) {
        Calendar s11 = x.s();
        this.f28941a = s11;
        this.f28942b = s11.getMaximum(7);
        this.f28943c = i11;
    }

    private int b(int i11) {
        int i12 = i11 + this.f28943c;
        int i13 = this.f28942b;
        return i12 > i13 ? i12 - i13 : i12;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i11) {
        if (i11 >= this.f28942b) {
            return null;
        }
        return Integer.valueOf(b(i11));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f28942b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i11) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i11, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f28941a.set(7, b(i11));
        textView.setText(this.f28941a.getDisplayName(7, f28940d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f28941a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
