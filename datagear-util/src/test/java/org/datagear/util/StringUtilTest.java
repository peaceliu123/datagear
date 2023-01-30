/*
 * Copyright 2018-2023 datagear.tech
 *
 * This file is part of DataGear.
 *
 * DataGear is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * DataGear is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with DataGear.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package org.datagear.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * {@linkplain StringUtil}单元测试类。
 * 
 * @author datagear@163.com
 *
 */
public class StringUtilTest
{
	@Test
	public void escapeHtmlTest()
	{
		{
			String  s ="abc<>\"&def";
			String actual = StringUtil.escapeHtml(s);
			assertEquals("abc&lt;&gt;&quot;&amp;def", actual);
		}
	}
	
	@Test
	public void maskTest()
	{
		{
			String s = null;
			String actual = StringUtil.mask(s, 2, 2, 2);
			assertEquals("**", actual);
		}

		{
			String s = "";
			String actual = StringUtil.mask(s, 2, 2, 2);
			assertEquals("**", actual);
		}

		{
			String s = "a";
			String actual = StringUtil.mask(s, 2, 2, 2);
			assertEquals("a**", actual);
		}

		{
			String s = "ab";
			String actual = StringUtil.mask(s, 2, 2, 2);
			assertEquals("ab**", actual);
		}

		{
			String s = "abc";
			String actual = StringUtil.mask(s, 2, 2, 2);
			assertEquals("ab**c", actual);
		}

		{
			String s = "abcd";
			String actual = StringUtil.mask(s, 2, 2, 2);
			assertEquals("ab**cd", actual);
		}

		{
			String s = "abcdefghi";
			String actual = StringUtil.mask(s, 2, 2, 2);
			assertEquals("ab**hi", actual);
		}

		//

		{
			String s = null;
			String actual = StringUtil.mask(s, 2, 0, 2);
			assertEquals("**", actual);
		}

		{
			String s = "";
			String actual = StringUtil.mask(s, 2, 0, 2);
			assertEquals("**", actual);
		}

		{
			String s = "a";
			String actual = StringUtil.mask(s, 2, 0, 2);
			assertEquals("a**", actual);
		}

		{
			String s = "ab";
			String actual = StringUtil.mask(s, 2, 0, 2);
			assertEquals("ab**", actual);
		}

		{
			String s = "abc";
			String actual = StringUtil.mask(s, 2, 0, 2);
			assertEquals("ab**", actual);
		}

		{
			String s = "abcd";
			String actual = StringUtil.mask(s, 2, 0, 2);
			assertEquals("ab**", actual);
		}

		{
			String s = "abcdefghi";
			String actual = StringUtil.mask(s, 2, 0, 2);
			assertEquals("ab**", actual);
		}

		//
		{
			String s = null;
			String actual = StringUtil.mask(s, 0, 2, 2);
			assertEquals("**", actual);
		}

		{
			String s = "";
			String actual = StringUtil.mask(s, 0, 2, 2);
			assertEquals("**", actual);
		}

		{
			String s = "a";
			String actual = StringUtil.mask(s, 0, 2, 2);
			assertEquals("**a", actual);
		}

		{
			String s = "ab";
			String actual = StringUtil.mask(s, 0, 2, 2);
			assertEquals("**ab", actual);
		}

		{
			String s = "abc";
			String actual = StringUtil.mask(s, 0, 2, 2);
			assertEquals("**bc", actual);
		}

		{
			String s = "abcd";
			String actual = StringUtil.mask(s, 0, 2, 2);
			assertEquals("**cd", actual);
		}

		{
			String s = "abcdefghi";
			String actual = StringUtil.mask(s, 0, 2, 2);
			assertEquals("**hi", actual);
		}

		//

		{
			String s = null;
			String actual = StringUtil.mask(s, 2, 2, 0);
			assertEquals("", actual);
		}

		{
			String s = "";
			String actual = StringUtil.mask(s, 2, 2, 0);
			assertEquals("", actual);
		}

		{
			String s = "a";
			String actual = StringUtil.mask(s, 2, 2, 0);
			assertEquals("a", actual);
		}

		{
			String s = "ab";
			String actual = StringUtil.mask(s, 2, 2, 0);
			assertEquals("ab", actual);
		}

		{
			String s = "abc";
			String actual = StringUtil.mask(s, 2, 2, 0);
			assertEquals("abc", actual);
		}

		{
			String s = "abcd";
			String actual = StringUtil.mask(s, 2, 2, 0);
			assertEquals("abcd", actual);
		}

		{
			String s = "abcdefghi";
			String actual = StringUtil.mask(s, 2, 2, 0);
			assertEquals("abhi", actual);
		}
	}

	@Test
	public void encodePathURLTest() throws Exception
	{
		{
			String url = "abc";
			String actual = StringUtil.encodePathURL(url, IOUtil.CHARSET_UTF_8);
			assertEquals(url, actual);
		}

		{
			String url = "abc/def/ghi";
			String actual = StringUtil.encodePathURL(url, IOUtil.CHARSET_UTF_8);
			assertEquals(url, actual);
		}

		{
			String url = "abc/中 文/?/ghi";
			String actual = StringUtil.encodePathURL(url, IOUtil.CHARSET_UTF_8);
			assertEquals("abc/%E4%B8%AD+%E6%96%87/%3F/ghi", actual);
			assertEquals(url, StringUtil.decodeURL(actual, IOUtil.CHARSET_UTF_8));
		}

		{
			String url = "/abc//中 文/?/ghi//";
			String actual = StringUtil.encodePathURL(url, IOUtil.CHARSET_UTF_8);
			assertEquals("/abc//%E4%B8%AD+%E6%96%87/%3F/ghi//", actual);
			assertEquals(url, StringUtil.decodeURL(actual, IOUtil.CHARSET_UTF_8));
		}
	}
}
