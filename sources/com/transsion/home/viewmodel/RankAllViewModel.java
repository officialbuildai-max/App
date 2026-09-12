package com.transsion.home.viewmodel;

import androidx.view.t0;
import androidx.view.u0;
import com.transsion.home.bean.RankAllData;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.List;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class RankAllViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.view.b0 f45874a = new androidx.view.b0();

    /* renamed from: b, reason: collision with root package name */
    private final androidx.view.b0 f45875b = new androidx.view.b0();

    /* renamed from: c, reason: collision with root package name */
    private int f45876c = 1;

    /* renamed from: d, reason: collision with root package name */
    private final ol.d f45877d = (ol.d) zg.c.f79537e.a().h(ol.d.class);

    /* renamed from: e, reason: collision with root package name */
    private String f45878e;

    /* renamed from: f, reason: collision with root package name */
    private int f45879f;

    /* renamed from: g, reason: collision with root package name */
    private String f45880g;

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(RankAllData rankAllData) {
        List<Subject> subjects;
        String ops = rankAllData != null ? rankAllData.getOps() : null;
        if (ops == null || ops.length() == 0 || rankAllData == null || (subjects = rankAllData.getSubjects()) == null) {
            return;
        }
        for (Subject subject : subjects) {
            String ops2 = subject.getOps();
            if (ops2 == null || ops2.length() == 0) {
                subject.setOps(ops);
            }
        }
    }

    private final void n(boolean z10) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RankAllViewModel$startRequest$1(z10, this, null), 2, null);
    }

    public final androidx.view.b0 i() {
        return this.f45875b;
    }

    public final androidx.view.b0 j() {
        return this.f45874a;
    }

    public final void k(String str, int i11, String str2) {
        this.f45878e = str;
        this.f45879f = i11;
        this.f45880g = str2;
        this.f45876c = 1;
        n(false);
    }

    public final void l() {
        n(true);
    }
}
