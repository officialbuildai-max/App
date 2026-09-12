package com.transsion.postdetail.util;

import com.transsion.moviedetailapi.bean.Subject;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f50221a = new h();

    private h() {
    }

    public final boolean a(Subject subject) {
        if (!(subject != null ? subject.isMovieType() : false)) {
            if (!(subject != null ? subject.isTvType() : false)) {
                return false;
            }
        }
        return true;
    }
}
