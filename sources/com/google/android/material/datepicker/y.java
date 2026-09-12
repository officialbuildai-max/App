package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class y extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    private final MaterialCalendar f28968a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f28969a;

        a(int i11) {
            this.f28969a = i11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            y.this.f28968a.p0(y.this.f28968a.g0().clamp(Month.b(this.f28969a, y.this.f28968a.i0().f28896a)));
            y.this.f28968a.q0(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends RecyclerView.b0 {

        /* renamed from: a, reason: collision with root package name */
        final TextView f28971a;

        b(TextView textView) {
            super(textView);
            this.f28971a = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MaterialCalendar materialCalendar) {
        this.f28968a = materialCalendar;
    }

    private View.OnClickListener h(int i11) {
        return new a(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f28968a.g0().getYearSpan();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i11) {
        return i11 - this.f28968a.g0().getStart().f28897b;
    }

    int j(int i11) {
        return this.f28968a.g0().getStart().f28897b + i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i11) {
        int j11 = j(i11);
        bVar.f28971a.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(j11)));
        TextView textView = bVar.f28971a;
        textView.setContentDescription(j.k(textView.getContext(), j11));
        com.google.android.material.datepicker.b h02 = this.f28968a.h0();
        Calendar q11 = x.q();
        com.google.android.material.datepicker.a aVar = q11.get(1) == j11 ? h02.f28923f : h02.f28921d;
        Iterator<Long> it = this.f28968a.j0().getSelectedDays().iterator();
        while (it.hasNext()) {
            q11.setTimeInMillis(it.next().longValue());
            if (q11.get(1) == j11) {
                aVar = h02.f28922e;
            }
        }
        aVar.d(bVar.f28971a);
        bVar.f28971a.setOnClickListener(h(j11));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
