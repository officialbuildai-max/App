package com.bigkoo.pickerview.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$layout;
import com.bigkoo.pickerview.R$string;
import java.text.ParseException;
import java.util.Calendar;
import q5.c;

/* loaded from: classes2.dex */
public class a extends BasePickerView implements View.OnClickListener {

    /* renamed from: p, reason: collision with root package name */
    private b f20049p;

    public a(p5.a aVar) {
        super(aVar.C);
        this.f20033e = aVar;
        y(aVar.C);
    }

    private void D() {
        b bVar = this.f20049p;
        p5.a aVar = this.f20033e;
        bVar.E(aVar.f72436h, aVar.f72437i);
        x();
    }

    private void E() {
        this.f20049p.H(this.f20033e.f72438j);
        this.f20049p.x(this.f20033e.f72439k);
    }

    private void F() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f20033e.f72435g;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i11 = calendar.get(1);
            i12 = calendar.get(2);
            i13 = calendar.get(5);
            i14 = calendar.get(11);
            i15 = calendar.get(12);
            i16 = calendar.get(13);
        } else {
            i11 = calendar2.get(1);
            i12 = this.f20033e.f72435g.get(2);
            i13 = this.f20033e.f72435g.get(5);
            i14 = this.f20033e.f72435g.get(11);
            i15 = this.f20033e.f72435g.get(12);
            i16 = this.f20033e.f72435g.get(13);
        }
        this.f20049p.D(i11, i12, i13, i14, i15, i16);
    }

    private void x() {
        p5.a aVar = this.f20033e;
        Calendar calendar = aVar.f72436h;
        if (calendar == null || aVar.f72437i == null) {
            if (calendar != null) {
                aVar.f72435g = calendar;
                return;
            }
            Calendar calendar2 = aVar.f72437i;
            if (calendar2 != null) {
                aVar.f72435g = calendar2;
                return;
            }
            return;
        }
        Calendar calendar3 = aVar.f72435g;
        if (calendar3 == null || calendar3.getTimeInMillis() < this.f20033e.f72436h.getTimeInMillis() || this.f20033e.f72435g.getTimeInMillis() > this.f20033e.f72437i.getTimeInMillis()) {
            p5.a aVar2 = this.f20033e;
            aVar2.f72435g = aVar2.f72436h;
        }
    }

    private void y(Context context) {
        s();
        o();
        n();
        this.f20033e.getClass();
        LayoutInflater.from(context).inflate(R$layout.pickerview_time, this.f20030b);
        TextView textView = (TextView) findViewById(R$id.tvTitle);
        TextView textView2 = (TextView) findViewById(R$id.btnSubmit);
        TextView textView3 = (TextView) findViewById(R$id.tv_ok);
        TextView textView4 = (TextView) findViewById(R$id.btnCancel);
        textView2.setTag("submit");
        textView3.setTag("submit");
        textView4.setTag("cancel");
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView2.setText(TextUtils.isEmpty(this.f20033e.D) ? context.getResources().getString(R$string.pickerview_submit) : this.f20033e.D);
        textView4.setText(TextUtils.isEmpty(this.f20033e.E) ? context.getResources().getString(R$string.pickerview_cancel) : this.f20033e.E);
        textView.setText(TextUtils.isEmpty(this.f20033e.F) ? "" : this.f20033e.F);
        textView.setTextColor(this.f20033e.I);
        textView.setTextSize(this.f20033e.M);
        z((LinearLayout) findViewById(R$id.timepicker));
    }

    private void z(LinearLayout linearLayout) {
        int i11;
        p5.a aVar = this.f20033e;
        this.f20049p = new b(linearLayout, aVar.f72434f, aVar.B, aVar.N);
        this.f20033e.getClass();
        this.f20049p.C(this.f20033e.f72441m);
        p5.a aVar2 = this.f20033e;
        int i12 = aVar2.f72438j;
        if (i12 != 0 && (i11 = aVar2.f72439k) != 0 && i12 <= i11) {
            E();
        }
        p5.a aVar3 = this.f20033e;
        Calendar calendar = aVar3.f72436h;
        if (calendar == null || aVar3.f72437i == null) {
            if (calendar == null) {
                Calendar calendar2 = aVar3.f72437i;
                if (calendar2 == null) {
                    D();
                } else {
                    if (calendar2.get(1) > 2100) {
                        throw new IllegalArgumentException("The endDate should not be later than 2100");
                    }
                    D();
                }
            } else {
                if (calendar.get(1) < 1900) {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
                D();
            }
        } else {
            if (calendar.getTimeInMillis() > this.f20033e.f72437i.getTimeInMillis()) {
                throw new IllegalArgumentException("startDate can't be later than endDate");
            }
            D();
        }
        F();
        b bVar = this.f20049p;
        p5.a aVar4 = this.f20033e;
        bVar.y(aVar4.f72442n, aVar4.f72443o, aVar4.f72444p, aVar4.f72445q, aVar4.f72446r, aVar4.f72447s);
        b bVar2 = this.f20049p;
        p5.a aVar5 = this.f20033e;
        bVar2.M(aVar5.f72448t, aVar5.f72449u, aVar5.f72450v, aVar5.f72451w, aVar5.f72452x, aVar5.f72453y);
        u(this.f20033e.U);
        this.f20049p.s(this.f20033e.f72440l);
        this.f20049p.u(this.f20033e.Q);
        this.f20049p.w(this.f20033e.X);
        this.f20049p.A(this.f20033e.S);
        this.f20049p.L(this.f20033e.O);
        this.f20049p.J(this.f20033e.P);
        this.f20049p.p(this.f20033e.V);
    }

    public void A() {
        if (this.f20033e.f72429a != null) {
            try {
                this.f20033e.f72429a.a(b.f20050y.parse(this.f20049p.o()), this.f20040l);
            } catch (ParseException e11) {
                e11.printStackTrace();
            }
        }
    }

    public void B(Calendar calendar) {
        this.f20033e.f72435g = calendar;
        F();
    }

    public void C() {
        c cVar = this.f20033e.f72429a;
        if (cVar != null) {
            cVar.a(null, this.f20040l);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((String) view.getTag()).equals("submit")) {
            A();
        } else {
            C();
        }
        f();
    }

    @Override // com.bigkoo.pickerview.view.BasePickerView
    public boolean p() {
        return this.f20033e.T;
    }
}
