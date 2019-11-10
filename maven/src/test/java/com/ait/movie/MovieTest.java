package com.ait.movie;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.Times;
import com.ait.DAO.MovieStoreDAO;
import com.ait.download.DownloadServer;
import com.ait.exception.MovieNotAvailable;
import com.ait.exception.MovieStoreDownloadException;
import com.ait.exception.MovieStoreException;
import com.ait.message.MailServer;
import com.ait.moviestore.Account;
import com.ait.moviestore.MovieStoreImpl;
import com.ait.moviestore.MovieTransaction;
import com.ait.payment.PayPalFacade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class MovieTest {
	
	private Account acc;
	private MovieStoreImpl msi;
	
	private MailServer mails;
	private DownloadServer ds;
	private PayPalFacade ppf;
	private MovieStoreDAO msd;
	private Movie movie;
	

	@BeforeEach
	void setUp() {
		mails = mock(MailServer.class);
		ds = mock(DownloadServer.class);
		ppf = mock(PayPalFacade.class);
		acc = new Account("123", "accName", "email");
		movie = new Movie("TestMovie", 10.0);
		msd = mock(MovieStoreDAO.class);
		//msi = new MovieStoreImpl(msd, ds, ppf, mails);
		msi = new MovieStoreImpl(msd, ds, ppf, mails);
	}

	
	@Test
	void downloadMovietest() throws MovieStoreException {
		when(msd.findAccountForId("123")).thenReturn(acc);
		when(msd.getAvailableMovieWithTitle("TestMovie")).thenReturn(movie);
		when(ds.startDownload(movie, acc)).thenReturn(true);
		assertEquals(movie, msi.downloadMovie("123", "TestMovie"));

		verify(ds, new Times(1)).startDownload(movie, acc);
		verify(msd, new Times(1)).createNewTransaction(isA(MovieTransaction.class));
		verify(ppf, new Times(1)).sendAdvice(movie.getChargePerDownload(), acc.getAccountId());
		verify(mails, new Times(1)).send(acc.getEmail(), "Download of " + movie.getTitle() + " started");

	}

	@Test
	void downloadMoviesAccFaileTest() throws MovieStoreException {
		when(msd.findAccountForId("123")).thenReturn(null);
		when(msd.getAvailableMovieWithTitle("TestMovie")).thenReturn(movie);
		when(ds.startDownload(movie, acc)).thenReturn(true);
		assertThrows(MovieStoreException.class, () -> msi.downloadMovie("123", "TestMovie"));

		verify(ds, new Times(0)).startDownload(movie, acc);
		verify(msd, new Times(0)).createNewTransaction(isA(MovieTransaction.class));
		verify(ppf, new Times(0)).sendAdvice(movie.getChargePerDownload(), acc.getAccountId());
		verify(mails, new Times(0)).send(acc.getEmail(), "Download of " + movie.getTitle() + " started");

	}

	@Test
	void downloadMoviesNotAvailableTest() throws MovieStoreException {
		when(msd.findAccountForId("123")).thenReturn(acc);
		when(msd.getAvailableMovieWithTitle("TestMovie")).thenReturn(null);
		when(ds.startDownload(movie, acc)).thenReturn(true);
		assertThrows(MovieNotAvailable.class, () -> msi.downloadMovie("123", "TestMovie"));

		verify(ds, new Times(0)).startDownload(movie, acc);
		verify(msd, new Times(0)).createNewTransaction(isA(MovieTransaction.class));
		verify(ppf, new Times(0)).sendAdvice(movie.getChargePerDownload(), acc.getAccountId());
		verify(mails, new Times(0)).send(acc.getEmail(), "Download of " + movie.getTitle() + " started");

	}
	 
	@Test
	void downloadMoviesDownloadExceptionTest() throws MovieStoreException {
		when(msd.findAccountForId("123")).thenReturn(acc);
		when(msd.getAvailableMovieWithTitle("TestMovie")).thenReturn(movie);
		//when(ds.startDownload(movie, acc)).thenReturn(true);
		when(ds.startDownload(movie, acc)).thenThrow(new MovieStoreDownloadException("Account not found: " + acc.getAccountId()));
		assertThrows(MovieStoreDownloadException.class, () -> msi.downloadMovie("123", "TestMovie"));
		
		verify(ds, new Times(1)).startDownload(movie, acc);
		verify(msd, new Times(0)).createNewTransaction(isA(MovieTransaction.class));
		verify(ppf, new Times(0)).sendAdvice(movie.getChargePerDownload(), acc.getAccountId());
		verify(mails, new Times(0)).send(acc.getEmail(), "Download of " + movie.getTitle() + " started");
		
	}
}
