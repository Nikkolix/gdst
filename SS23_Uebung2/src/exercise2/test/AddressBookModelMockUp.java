/*
 * Example code used in exercises for lecture "Grundlagen des Software-Testens"
 * Created and given by Ina Schieferdecker, Theo Vassiliou and Diana Serbanescu
 * Technische Universität Berlin
 */
package exercise2.test;

import java.io.IOException;
import java.util.Collection;

import exercise2.addressbook.model.AddressBookModel;
import exercise2.addressbook.model.Entry;
import exercise2.addressbook.model.SizeLimitReachedException;

/**
 * Uebung 2 - Komponenten und Integrationstest
 * Mock-Up für das AddressBookModel
 * 
 * Bitte Nummer der Gruppe eintragen: 23
 * 
 * @author Ella Friederike Bredow
 * @author Hok Kai John Cheung
 * @author Sonja Höhmann
 * @author Luca Garriet Janßen
 * @author Niklas Markus Keitsch
 * @author Paul Michael Kilian
 * @author Jakob Krauskopf
 * @author Luca Benedict Lichterman
 * @author Hanna Leoni Riegel
 * @author Merlin Schumann
 */
public class AddressBookModelMockUp implements AddressBookModel {
	private int size = 0;
	
	@Override
	public boolean addEntry(Entry entry) throws SizeLimitReachedException {
		if (this.size == 1) {
			throw new SizeLimitReachedException("Size limit reached");
		}
		this.size++;
		return true;
	}
	
	@Override
	public Entry getEntry(String surName, String firstName) {
		return null;
	}
	
	@Override
	public Collection<Entry> getEntries() {
		return null;
	}
	
	@Override
	public boolean deleteEntry(Entry entry) {
		return true;
	}
	
	@Override
	public void erase() {
		return;
	}
	
	@Override
	public void load() throws IOException{
		return;
	}
	
	@Override
	public void save() throws IOException{
		return;
	}
}
