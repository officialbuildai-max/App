package com.transsion.search.speech;

import android.speech.SpeechRecognizer;
import com.blankj.utilcode.util.Utils;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f52269a = new g();

    private g() {
    }

    public final boolean a() {
        return SpeechRecognizer.isRecognitionAvailable(Utils.a());
    }
}
