package com.transsion.baseui.music;

import androidx.view.u;
import com.transsion.player.mediasession.MediaItem;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a implements androidx.view.f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f43533a = new a();

    private a() {
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.view.e.a(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.view.e.b(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.view.e.c(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.view.e.d(this, uVar);
    }

    @Override // androidx.view.f
    public void onStart(u owner) {
        Intrinsics.h(owner, "owner");
        androidx.view.e.e(this, owner);
        MediaItem q11 = MusicFloatManager.f43508h.b().q();
        if (q11 != null) {
            q11.setInBackground(Boolean.FALSE);
        }
    }

    @Override // androidx.view.f
    public void onStop(u owner) {
        Intrinsics.h(owner, "owner");
        androidx.view.e.f(this, owner);
        MediaItem q11 = MusicFloatManager.f43508h.b().q();
        if (q11 != null) {
            q11.setInBackground(Boolean.TRUE);
        }
        MusicReport.f43527a.c();
    }
}
