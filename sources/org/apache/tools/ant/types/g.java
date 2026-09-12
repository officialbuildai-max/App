package org.apache.tools.ant.types;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    protected Vector f71591a = new Vector();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f71592a;

        /* renamed from: b, reason: collision with root package name */
        private String f71593b;

        public String a() {
            d();
            StringBuffer stringBuffer = new StringBuffer(this.f71592a.trim());
            stringBuffer.append(UrlUtils.EQUAL_MARK);
            stringBuffer.append(this.f71593b.trim());
            return stringBuffer.toString();
        }

        public String b() {
            return this.f71592a;
        }

        public String c() {
            return this.f71593b;
        }

        public void d() {
            if (this.f71592a == null || this.f71593b == null) {
                throw new BuildException("key and value must be specified for environment variables.");
            }
        }
    }

    public String[] a() {
        if (this.f71591a.size() == 0) {
            return null;
        }
        int size = this.f71591a.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = ((a) this.f71591a.elementAt(i11)).a();
        }
        return strArr;
    }
}
