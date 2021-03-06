/*
 * #%L
 * BigDataViewer core classes with minimal dependencies
 * %%
 * Copyright (C) 2012 - 2015 BigDataViewer authors
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imglib2.type.volatiles;

import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.NumericType;
import net.imglib2.util.Fraction;

/**
 * Abstract base class for {@link VolatileNumericType}s that wrap
 * {@link NativeType native} {@link NumericType}s.
 *
 * @param <N>
 *            wrapped {@link NativeType native} {@link NumericType}.
 * @param <T>
 *            type of derived concrete class.
 *
 * @author Tobias Pietzsch &lt;tobias.pietzsch@gmail.com&gt;
 * @author Stephan Saalfeld &lt;saalfelds@janelia.hhmi.org&gt;
 */
public abstract class AbstractVolatileNativeNumericType< N extends NumericType< N > & NativeType< N >, T extends AbstractVolatileNativeNumericType< N, T > >
	extends AbstractVolatileNumericType< N, T >
	implements NativeType< T >
{
	public AbstractVolatileNativeNumericType( final N t, final boolean valid )
	{
		super( t, valid );
	}

	@Override
	public Fraction getEntitiesPerPixel()
	{
		return t.getEntitiesPerPixel();
	}

	@Override
	public void updateIndex( final int i )
	{
		t.updateIndex( i );
	}

	@Override
	public int getIndex()
	{
		return t.getIndex();
	}

	@Override
	public void incIndex()
	{
		t.incIndex();
	}

	@Override
	public void incIndex( final int increment )
	{
		t.incIndex( increment );
	}

	@Override
	public void decIndex()
	{
		t.decIndex();
	}

	@Override
	public void decIndex( final int decrement )
	{
		t.decIndex( decrement );
	}
}
