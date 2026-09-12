package com.transsion.player.longvideo.helper;

import com.transsion.player.longvideo.ui.LongVodPlayerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    public static final a f48085b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private String f48086a = "";

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean b(go.c cVar, String str) {
        Integer v11 = StringsKt.v(str);
        int intValue = v11 != null ? v11.intValue() : 0;
        Integer v12 = StringsKt.v(cVar.e());
        int intValue2 = v12 != null ? v12.intValue() : 0;
        return intValue2 > 0 && intValue > 0 && intValue2 > intValue;
    }

    private final Object c(go.a aVar, Continuation continuation) {
        Object obj;
        Object obj2;
        go.c cVar;
        List j11 = aVar.j();
        if (j11.isEmpty()) {
            return null;
        }
        String str = this.f48086a;
        if (str.length() == 0) {
            str = com.transsion.baselib.report.launch.b.f43424a.b().getString("key_stream_resolution", "");
            if (str == null) {
                str = "";
            }
            this.f48086a = str;
        }
        a.C0856a.f(lg.a.f68962a, LongVodPlayerView.TAG, "getMp4DefaultPlayBean, savedResolution： " + this.f48086a, false, 4, null);
        List<go.c> list = j11;
        go.c cVar2 = null;
        for (go.c cVar3 : list) {
            if (!cVar3.j()) {
                cVar2 = cVar3;
            }
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (str.length() == 0) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    Integer v11 = StringsKt.v(((go.c) obj).e());
                    int intValue = v11 != null ? v11.intValue() : 0;
                    do {
                        Object next = it.next();
                        Integer v12 = StringsKt.v(((go.c) next).e());
                        int intValue2 = v12 != null ? v12.intValue() : 0;
                        if (intValue < intValue2) {
                            obj = next;
                            intValue = intValue2;
                        }
                    } while (it.hasNext());
                }
            } else {
                obj = null;
            }
        } else {
            for (go.c cVar4 : list) {
                if (Intrinsics.c(cVar4.e(), str)) {
                    cVar2 = cVar4;
                }
            }
            if (cVar2 == null) {
                Iterator it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    if (b((go.c) obj2, str)) {
                        break;
                    }
                }
                obj = (go.c) obj2;
            } else {
                obj = cVar2;
            }
        }
        if (obj == null) {
            obj = CollectionsKt.u0(j11);
        }
        if (this.f48086a.length() == 0 && (cVar = (go.c) obj) != null) {
            f(cVar.e());
        }
        go.c cVar5 = (go.c) obj;
        a.C0856a.f(lg.a.f68962a, LongVodPlayerView.TAG, "getMp4DefaultPlayBean, bean.resolutions： " + (cVar5 != null ? cVar5.e() : null), false, 4, null);
        return obj;
    }

    public final Object a(go.a aVar, Continuation continuation) {
        if (aVar.j().isEmpty()) {
            return null;
        }
        go.c cVar = (go.c) CollectionsKt.i0(aVar.j());
        com.transsion.player.longvideo.member.k.f48279a.a("LongVodResolutionHelper --> getDefaultPlayStream() --> 是MP4格式 = " + aVar.w());
        return aVar.w() ? c(aVar, continuation) : cVar;
    }

    public final go.c d(go.a bean, go.b config) {
        Intrinsics.h(bean, "bean");
        Intrinsics.h(config, "config");
        for (go.c cVar : bean.j()) {
            if (StringsKt.c0(config.d(), cVar.e(), false, 2, null)) {
                return cVar;
            }
        }
        return null;
    }

    public final List e(go.c playStream, List mp4Streams) {
        Intrinsics.h(playStream, "playStream");
        Intrinsics.h(mp4Streams, "mp4Streams");
        ArrayList arrayList = new ArrayList();
        Iterator it = mp4Streams.iterator();
        while (it.hasNext()) {
            go.c cVar = (go.c) it.next();
            arrayList.add(new go.b(Intrinsics.c(cVar.e(), playStream.e()), cVar.e() + "P", null, 4, null));
        }
        return arrayList;
    }

    public final void f(String resolution) {
        Intrinsics.h(resolution, "resolution");
        a.C0856a.f(lg.a.f68962a, LongVodPlayerView.TAG, "save, resolution： " + resolution, false, 4, null);
        this.f48086a = resolution;
        com.transsion.baselib.report.launch.b.f43424a.b().putString("key_stream_resolution", resolution);
    }
}
