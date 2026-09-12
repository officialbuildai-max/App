package com.transsion.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private int f46135a;

    /* renamed from: b, reason: collision with root package name */
    private final Reader f46136b;

    /* renamed from: c, reason: collision with root package name */
    private char f46137c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f46138d;

    public l(Reader reader) {
        this.f46136b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f46138d = false;
        this.f46135a = 0;
    }

    public l(String str) {
        this(new StringReader(str));
    }

    private void e(Map map, String str, Object obj) {
        if (str != null) {
            if (!map.containsKey(str)) {
                map.put(str, obj);
                return;
            }
            throw new k("Duplicate key \"" + str + "\"");
        }
    }

    private boolean g(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (!Character.isDigit(charAt) && charAt != '-' && charAt != '.' && charAt != '+' && charAt != 'e' && charAt != 'E') {
                return false;
            }
        }
        return true;
    }

    private Object i(String str) {
        if (str.equals("")) {
            return str;
        }
        if (str.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (str.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (str.equalsIgnoreCase("null")) {
            return null;
        }
        return g(str) ? new n(str) : str;
    }

    private Map l() {
        HashMap hashMap = new HashMap();
        if (h() != '{') {
            throw a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char h11 = h();
            if (h11 == 0) {
                throw a("A JSONObject text must end with '}'");
            }
            if (h11 == '}') {
                return hashMap;
            }
            d();
            String obj = j().toString();
            char h12 = h();
            if (h12 == '=') {
                if (f() != '>') {
                    d();
                }
            } else if (h12 != ':') {
                throw a("Expected a ':' after a key");
            }
            e(hashMap, obj, j());
            char h13 = h();
            if (h13 != ',' && h13 != ';') {
                if (h13 == '}') {
                    return hashMap;
                }
                throw a("Expected a ',' or '}'");
            }
            if (h() == '}') {
                return hashMap;
            }
            d();
        }
    }

    public k a(String str) {
        return new k(str + toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0084, code lost:
    
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b(char r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5:
            char r1 = r5.f()
            if (r1 == 0) goto L7e
            r2 = 10
            if (r1 == r2) goto L7e
            r3 = 13
            if (r1 == r3) goto L7e
            r4 = 92
            if (r1 == r4) goto L22
            if (r1 != r6) goto L1e
            java.lang.String r6 = r0.toString()
            return r6
        L1e:
            r0.append(r1)
            goto L5
        L22:
            char r1 = r5.f()
            r4 = 98
            if (r1 == r4) goto L78
            r4 = 102(0x66, float:1.43E-43)
            if (r1 == r4) goto L72
            r4 = 110(0x6e, float:1.54E-43)
            if (r1 == r4) goto L6e
            r2 = 114(0x72, float:1.6E-43)
            if (r1 == r2) goto L6a
            r2 = 120(0x78, float:1.68E-43)
            r3 = 16
            if (r1 == r2) goto L5c
            r2 = 116(0x74, float:1.63E-43)
            if (r1 == r2) goto L56
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L48
            r0.append(r1)
            goto L5
        L48:
            r1 = 4
            java.lang.String r1 = r5.c(r1)
            int r1 = java.lang.Integer.parseInt(r1, r3)
            char r1 = (char) r1
            r0.append(r1)
            goto L5
        L56:
            r1 = 9
            r0.append(r1)
            goto L5
        L5c:
            r1 = 2
            java.lang.String r1 = r5.c(r1)
            int r1 = java.lang.Integer.parseInt(r1, r3)
            char r1 = (char) r1
            r0.append(r1)
            goto L5
        L6a:
            r0.append(r3)
            goto L5
        L6e:
            r0.append(r2)
            goto L5
        L72:
            r1 = 12
            r0.append(r1)
            goto L5
        L78:
            r1 = 8
            r0.append(r1)
            goto L5
        L7e:
            java.lang.String r6 = "Unterminated string"
            com.transsion.json.k r6 = r5.a(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.json.l.b(char):java.lang.String");
    }

    public String c(int i11) {
        if (i11 == 0) {
            return "";
        }
        char[] cArr = new char[i11];
        int i12 = 0;
        if (this.f46138d) {
            this.f46138d = false;
            cArr[0] = this.f46137c;
            i12 = 1;
        }
        while (i12 < i11) {
            try {
                int read = this.f46136b.read(cArr, i12, i11 - i12);
                if (read == -1) {
                    break;
                }
                i12 += read;
            } catch (IOException e11) {
                throw new k(e11);
            }
        }
        this.f46135a += i12;
        if (i12 < i11) {
            throw a("Substring bounds error");
        }
        this.f46137c = cArr[i11 - 1];
        return new String(cArr);
    }

    public void d() {
        int i11;
        if (this.f46138d || (i11 = this.f46135a) <= 0) {
            throw new k("Stepping back two steps is not supported");
        }
        this.f46135a = i11 - 1;
        this.f46138d = true;
    }

    public char f() {
        if (this.f46138d) {
            this.f46138d = false;
            char c11 = this.f46137c;
            if (c11 != 0) {
                this.f46135a++;
            }
            return c11;
        }
        try {
            int read = this.f46136b.read();
            if (read <= 0) {
                this.f46137c = (char) 0;
                return (char) 0;
            }
            this.f46135a++;
            char c12 = (char) read;
            this.f46137c = c12;
            return c12;
        } catch (IOException e11) {
            throw new k(e11);
        }
    }

    public char h() {
        char f11;
        do {
            f11 = f();
            if (f11 == 0) {
                break;
            }
        } while (f11 <= ' ');
        return f11;
    }

    public Object j() {
        char h11 = h();
        if (h11 != '\"') {
            if (h11 != '[') {
                if (h11 == '{') {
                    d();
                    return l();
                }
                if (h11 != '\'') {
                    if (h11 != '(') {
                        StringBuilder sb2 = new StringBuilder();
                        while (h11 >= ' ' && ",:]}/\\\"[{;=#".indexOf(h11) < 0) {
                            sb2.append(h11);
                            h11 = f();
                        }
                        d();
                        String trim = sb2.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        }
                        return i(trim);
                    }
                }
            }
            d();
            return k();
        }
        return b(h11);
    }

    public List k() {
        char c11;
        char h11;
        ArrayList arrayList = new ArrayList();
        char h12 = h();
        if (h12 == '[') {
            c11 = ']';
        } else {
            if (h12 != '(') {
                throw a("A JSONArray text must start with '['");
            }
            c11 = ')';
        }
        if (h() == ']') {
            return arrayList;
        }
        d();
        while (true) {
            if (h() == ',') {
                d();
                arrayList.add(null);
            } else {
                d();
                arrayList.add(j());
            }
            h11 = h();
            if (h11 == ')') {
                break;
            }
            if (h11 == ',' || h11 == ';') {
                if (h() == ']') {
                    return arrayList;
                }
                d();
            } else if (h11 != ']') {
                throw a("Expected a ',' or ']'");
            }
        }
        if (c11 == h11) {
            return arrayList;
        }
        throw a("Expected a '" + c11 + "'");
    }

    public String toString() {
        return " at character " + this.f46135a;
    }
}
