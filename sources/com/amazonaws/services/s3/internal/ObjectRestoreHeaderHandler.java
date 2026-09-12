package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class ObjectRestoreHeaderHandler<T extends ObjectRestoreResult> implements HeaderHandler<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f18729a = Pattern.compile("expiry-date=\"(.*?)\"");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f18730b = Pattern.compile("ongoing-request=\"(.*?)\"");

    /* renamed from: c, reason: collision with root package name */
    private static final Log f18731c = LogFactory.b(ObjectRestoreHeaderHandler.class);

    private Boolean c(String str) {
        Matcher matcher = f18730b.matcher(str);
        if (matcher.find()) {
            return Boolean.valueOf(Boolean.parseBoolean(matcher.group(1)));
        }
        return null;
    }

    private Date d(String str) {
        Matcher matcher = f18729a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.e(matcher.group(1));
        } catch (Exception e11) {
            f18731c.i("Error parsing expiry-date from x-amz-restore header.", e11);
            return null;
        }
    }

    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(ObjectRestoreResult objectRestoreResult, HttpResponse httpResponse) {
        String str = (String) httpResponse.c().get("x-amz-restore");
        if (str != null) {
            objectRestoreResult.setRestoreExpirationTime(d(str));
            Boolean c11 = c(str);
            if (c11 != null) {
                objectRestoreResult.setOngoingRestore(c11.booleanValue());
            }
        }
    }
}
