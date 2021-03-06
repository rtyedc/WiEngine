/*
 * Copyright (c) 2010 WiYun Inc.
 * Author: luma(stubma@gmail.com)
 *
 * For all entities this program is free software; you can redistribute
 * it and/or modify it under the terms of the 'WiEngine' license with
 * the additional provision that 'WiEngine' must be credited in a manner
 * that can be be observed by end users, for example, in the credits or during
 * start up. (please find WiEngine logo in sdk's logo folder)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.wiyun.engine.types;

public class WYColor4B {
	/**
	 * byte count of GL format
	 */
	public static final int GL_SIZE = 4;

	public int r;
	public int g;
	public int b;
	public int a;
	
	public static WYColor4B make(int r, int g, int b, int a) {
		return new WYColor4B(r, g, b, a);
	}

	public WYColor4B() {
		r = g = b = a = 0xff;
	}

	public WYColor4B(int rr, int gg, int bb, int aa) {
		r = rr;
		g = gg;
		b = bb;
		a = aa;
	}

	public byte[] glFormat() {
		return new byte[] {
				(byte)r, (byte)g, (byte)b, (byte)a
		};
	}

	public int androidColor() {
		return (a << 24) | (r << 16) | (g << 8) | b;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof WYColor3B) {
			WYColor3B c = (WYColor3B)o;
			return r == c.r && g == c.g && b == c.b;
		} else if(o instanceof WYColor4B) {
			WYColor4B c = (WYColor4B)o;
			return r == c.r && g == c.g && b == c.b && a == c.b;
		} else if(o instanceof WYColor4F) {
			WYColor4F c = (WYColor4F)o;
			return r == (int)(c.r * 255) && g == (int)(c.g * 255) && b == (int)(c.b * 255) && a == (int)(c.a * 255);
		} else {
			return super.equals(o);
		}
	}

	@Override
	public String toString() {
		return "< r=" + r + ", g=" + g + ", b=" + b + ", a=" + a + " >";
	}
}
