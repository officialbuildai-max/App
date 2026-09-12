package com.vungle.ads.internal.network.converters;

import kotlin.Unit;
import kotlin.io.CloseableKt;
import okhttp3.ResponseBody;

/* loaded from: classes7.dex */
public final class b implements a {
    @Override // com.vungle.ads.internal.network.converters.a
    public Void convert(ResponseBody responseBody) {
        if (responseBody != null) {
            try {
                responseBody.close();
                Unit unit = Unit.f67184a;
                CloseableKt.a(responseBody, null);
            } finally {
            }
        }
        return null;
    }
}
