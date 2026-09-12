package com.transsion.search_pugc.speech;

import android.speech.SpeechRecognizer;
import com.blankj.utilcode.util.Utils;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f52580a = new g();

    private g() {
    }

    public final boolean a() {
        return SpeechRecognizer.isRecognitionAvailable(Utils.a());
    }
}
