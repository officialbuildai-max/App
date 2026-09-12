package mp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f69804a = new g();

    private g() {
    }

    public final int a(Context context, float f11) {
        Intrinsics.h(context, "context");
        return (int) ((f11 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final gp.a b(Context context, Uri uri) {
        Intrinsics.h(context, "context");
        if (uri == null) {
            return null;
        }
        String[] strArr = {"_data", CampaignEx.JSON_KEY_TITLE, "artist", "_size", "height", "width", "duration"};
        gp.a aVar = new gp.a();
        try {
            Cursor query = context.getContentResolver().query(uri, strArr, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        aVar.j(query.getString(query.getColumnIndex("_data")));
                        aVar.l(query.getString(query.getColumnIndex(CampaignEx.JSON_KEY_TITLE)));
                        aVar.h(query.getLong(query.getColumnIndex("duration")));
                        aVar.g(query.getString(query.getColumnIndex("artist")));
                        aVar.k(query.getLong(query.getColumnIndex("_size")));
                        aVar.m(query.getInt(query.getColumnIndex("width")));
                        aVar.i(query.getInt(query.getColumnIndex("height")));
                        String e11 = aVar.e();
                        long a11 = aVar.a();
                        String c11 = aVar.c();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("ContentUri:title-");
                        sb2.append(e11);
                        sb2.append(" duration:");
                        sb2.append(a11);
                        sb2.append(" ");
                        sb2.append(c11);
                        sb2.append(" \n uri:");
                        sb2.append(uri);
                    }
                } finally {
                }
            }
            Unit unit = Unit.f67184a;
            CloseableKt.a(query, null);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        return aVar;
    }
}
