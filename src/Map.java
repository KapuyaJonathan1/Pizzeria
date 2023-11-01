import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Map {

	private boolean moveCharacter = false;
	
	private int blockSize = 48;
	
	private int speed = 6;
	
	int x = 0;
	
	int sx = 22;
	
	int limit;
	
	private ArrayList<ArrayList<Portal>> portals;

	private ArrayList<ArrayList<Block>> blocks;
	
	private ArrayList<ArrayList<Spike>> spikes;
	
	private int mapSize;
	
	private PApplet g;
	
	private boolean gameMap = false;
	
	public Map(int mapSize, boolean gameMap, PApplet g) {
		
		this.gameMap = gameMap;
		
		this.mapSize = mapSize;
		
		limit = blockSize * mapSize;
		
		this.g = g;
		
	}
	
	public void setup(int map) {
		
		blocks = new ArrayList<ArrayList<Block>>();
		
		spikes = new ArrayList<ArrayList<Spike>>();
		
		portals = new ArrayList<ArrayList<Portal>>();

		instantiate(map);
		
	}
	
	public void instantiate(int map) {
		
		if(gameMap) {
			
				for(int i = 0; i < mapSize; i++) {
					
					blocks.add(new ArrayList<Block>());
					spikes.add(new ArrayList<Spike>());
					portals.add(new ArrayList<Portal>());
				}

				if(map == 1) {
				
					blocks.get(0).add(new Block(0* blockSize, 13 * blockSize, 48, 48));
					blocks.get(0).add(new Block(0* blockSize, 2 * blockSize, 48, 48));
					blocks.get(1).add(new Block(1* blockSize, 13 * blockSize, 48, 48));
					blocks.get(1).add(new Block(1* blockSize, 2 * blockSize, 48, 48));
					blocks.get(2).add(new Block(2* blockSize, 13 * blockSize, 48, 48));
					blocks.get(2).add(new Block(2* blockSize, 2 * blockSize, 48, 48));
					blocks.get(3).add(new Block(3* blockSize, 13 * blockSize, 48, 48));
					blocks.get(3).add(new Block(3* blockSize, 2 * blockSize, 48, 48));
					blocks.get(4).add(new Block(4* blockSize, 13 * blockSize, 48, 48));
					blocks.get(4).add(new Block(4* blockSize, 2 * blockSize, 48, 48));
					blocks.get(5).add(new Block(5* blockSize, 13 * blockSize, 48, 48));
					blocks.get(5).add(new Block(5* blockSize, 2 * blockSize, 48, 48));
					blocks.get(6).add(new Block(6* blockSize, 13 * blockSize, 48, 48));
					blocks.get(6).add(new Block(6* blockSize, 2 * blockSize, 48, 48));
					blocks.get(7).add(new Block(7* blockSize, 13 * blockSize, 48, 48));
					blocks.get(7).add(new Block(7* blockSize, 2 * blockSize, 48, 48));
					blocks.get(8).add(new Block(8* blockSize, 13 * blockSize, 48, 48));
					blocks.get(8).add(new Block(8* blockSize, 2 * blockSize, 48, 48));
					blocks.get(9).add(new Block(9* blockSize, 13 * blockSize, 48, 48));
					blocks.get(9).add(new Block(9* blockSize, 2 * blockSize, 48, 48));
					blocks.get(10).add(new Block(10* blockSize, 8 * blockSize, 48, 48));
					blocks.get(10).add(new Block(10* blockSize, 13 * blockSize, 48, 48));
					blocks.get(10).add(new Block(10* blockSize, 2 * blockSize, 48, 48));
					blocks.get(11).add(new Block(11* blockSize, 8 * blockSize, 48, 48));
					blocks.get(11).add(new Block(11* blockSize, 13 * blockSize, 48, 48));
					blocks.get(11).add(new Block(11* blockSize, 2 * blockSize, 48, 48));
					blocks.get(12).add(new Block(12* blockSize, 8 * blockSize, 48, 48));
					blocks.get(12).add(new Block(12* blockSize, 13 * blockSize, 48, 48));
					blocks.get(12).add(new Block(12* blockSize, 2 * blockSize, 48, 48));
					blocks.get(13).add(new Block(13* blockSize, 8 * blockSize, 48, 48));
					blocks.get(13).add(new Block(13* blockSize, 13 * blockSize, 48, 48));
					blocks.get(13).add(new Block(13* blockSize, 2 * blockSize, 48, 48));
					blocks.get(14).add(new Block(14* blockSize, 8 * blockSize, 48, 48));
					blocks.get(14).add(new Block(14* blockSize, 13 * blockSize, 48, 48));
					blocks.get(14).add(new Block(14* blockSize, 2 * blockSize, 48, 48));
					blocks.get(15).add(new Block(15* blockSize, 8 * blockSize, 48, 48));
					blocks.get(15).add(new Block(15* blockSize, 13 * blockSize, 48, 48));
					blocks.get(15).add(new Block(15* blockSize, 2 * blockSize, 48, 48));
					blocks.get(16).add(new Block(16* blockSize, 8 * blockSize, 48, 48));
					blocks.get(16).add(new Block(16* blockSize, 13 * blockSize, 48, 48));
					blocks.get(16).add(new Block(16* blockSize, 2 * blockSize, 48, 48));
					blocks.get(17).add(new Block(17* blockSize, 8 * blockSize, 48, 48));
					blocks.get(17).add(new Block(17* blockSize, 13 * blockSize, 48, 48));
					blocks.get(17).add(new Block(17* blockSize, 2 * blockSize, 48, 48));
					blocks.get(18).add(new Block(18* blockSize, 8 * blockSize, 48, 48));
					blocks.get(18).add(new Block(18* blockSize, 13 * blockSize, 48, 48));
					blocks.get(18).add(new Block(18* blockSize, 2 * blockSize, 48, 48));
					blocks.get(19).add(new Block(19* blockSize, 8 * blockSize, 48, 48));
					blocks.get(19).add(new Block(19* blockSize, 13 * blockSize, 48, 48));
					blocks.get(19).add(new Block(19* blockSize, 2 * blockSize, 48, 48));
					blocks.get(20).add(new Block(20* blockSize, 13 * blockSize, 48, 48));
					blocks.get(20).add(new Block(20* blockSize, 2 * blockSize, 48, 48));
					blocks.get(21).add(new Block(21* blockSize, 13 * blockSize, 48, 48));
					blocks.get(21).add(new Block(21* blockSize, 2 * blockSize, 48, 48));
					blocks.get(22).add(new Block(22* blockSize, 13 * blockSize, 48, 48));
					blocks.get(22).add(new Block(22* blockSize, 2 * blockSize, 48, 48));
					blocks.get(23).add(new Block(23* blockSize, 13 * blockSize, 48, 48));
					blocks.get(23).add(new Block(23* blockSize, 2 * blockSize, 48, 48));
					blocks.get(24).add(new Block(24* blockSize, 13 * blockSize, 48, 48));
					blocks.get(24).add(new Block(24* blockSize, 2 * blockSize, 48, 48));
					blocks.get(25).add(new Block(25* blockSize, 13 * blockSize, 48, 48));
					blocks.get(25).add(new Block(25* blockSize, 2 * blockSize, 48, 48));
					blocks.get(26).add(new Block(26* blockSize, 13 * blockSize, 48, 48));
					blocks.get(26).add(new Block(26* blockSize, 2 * blockSize, 48, 48));
					blocks.get(27).add(new Block(27* blockSize, 13 * blockSize, 48, 48));
					blocks.get(27).add(new Block(27* blockSize, 2 * blockSize, 48, 48));
					blocks.get(28).add(new Block(28* blockSize, 5 * blockSize, 48, 48));
					blocks.get(28).add(new Block(28* blockSize, 13 * blockSize, 48, 48));
					blocks.get(28).add(new Block(28* blockSize, 2 * blockSize, 48, 48));
					blocks.get(29).add(new Block(29* blockSize, 5 * blockSize, 48, 48));
					blocks.get(29).add(new Block(29* blockSize, 13 * blockSize, 48, 48));
					blocks.get(29).add(new Block(29* blockSize, 2 * blockSize, 48, 48));
					blocks.get(30).add(new Block(30* blockSize, 5 * blockSize, 48, 48));
					blocks.get(30).add(new Block(30* blockSize, 13 * blockSize, 48, 48));
					blocks.get(30).add(new Block(30* blockSize, 2 * blockSize, 48, 48));
					blocks.get(31).add(new Block(31* blockSize, 5 * blockSize, 48, 48));
					blocks.get(31).add(new Block(31* blockSize, 13 * blockSize, 48, 48));
					blocks.get(31).add(new Block(31* blockSize, 2 * blockSize, 48, 48));
					blocks.get(32).add(new Block(32* blockSize, 5 * blockSize, 48, 48));
					blocks.get(32).add(new Block(32* blockSize, 13 * blockSize, 48, 48));
					blocks.get(32).add(new Block(32* blockSize, 2 * blockSize, 48, 48));
					blocks.get(33).add(new Block(33* blockSize, 5 * blockSize, 48, 48));
					blocks.get(33).add(new Block(33* blockSize, 13 * blockSize, 48, 48));
					blocks.get(33).add(new Block(33* blockSize, 2 * blockSize, 48, 48));
					blocks.get(34).add(new Block(34* blockSize, 5 * blockSize, 48, 48));
					blocks.get(34).add(new Block(34* blockSize, 13 * blockSize, 48, 48));
					blocks.get(34).add(new Block(34* blockSize, 2 * blockSize, 48, 48));
					blocks.get(35).add(new Block(35* blockSize, 5 * blockSize, 48, 48));
					blocks.get(35).add(new Block(35* blockSize, 13 * blockSize, 48, 48));
					blocks.get(35).add(new Block(35* blockSize, 2 * blockSize, 48, 48));
					blocks.get(36).add(new Block(36* blockSize, 13 * blockSize, 48, 48));
					blocks.get(36).add(new Block(36* blockSize, 2 * blockSize, 48, 48));
					blocks.get(37).add(new Block(37* blockSize, 13 * blockSize, 48, 48));
					blocks.get(37).add(new Block(37* blockSize, 2 * blockSize, 48, 48));
					blocks.get(38).add(new Block(38* blockSize, 13 * blockSize, 48, 48));
					blocks.get(38).add(new Block(38* blockSize, 2 * blockSize, 48, 48));
					blocks.get(39).add(new Block(39* blockSize, 13 * blockSize, 48, 48));
					blocks.get(39).add(new Block(39* blockSize, 2 * blockSize, 48, 48));
					blocks.get(40).add(new Block(40* blockSize, 13 * blockSize, 48, 48));
					blocks.get(40).add(new Block(40* blockSize, 2 * blockSize, 48, 48));
					blocks.get(41).add(new Block(41* blockSize, 13 * blockSize, 48, 48));
					blocks.get(41).add(new Block(41* blockSize, 2 * blockSize, 48, 48));
					blocks.get(42).add(new Block(42* blockSize, 13 * blockSize, 48, 48));
					blocks.get(42).add(new Block(42* blockSize, 2 * blockSize, 48, 48));
					blocks.get(43).add(new Block(43* blockSize, 13 * blockSize, 48, 48));
					blocks.get(43).add(new Block(43* blockSize, 2 * blockSize, 48, 48));
					blocks.get(44).add(new Block(44* blockSize, 13 * blockSize, 48, 48));
					blocks.get(44).add(new Block(44* blockSize, 2 * blockSize, 48, 48));
					blocks.get(45).add(new Block(45* blockSize, 13 * blockSize, 48, 48));
					blocks.get(45).add(new Block(45* blockSize, 2 * blockSize, 48, 48));
					blocks.get(46).add(new Block(46* blockSize, 13 * blockSize, 48, 48));
					blocks.get(46).add(new Block(46* blockSize, 2 * blockSize, 48, 48));
					blocks.get(47).add(new Block(47* blockSize, 13 * blockSize, 48, 48));
					blocks.get(47).add(new Block(47* blockSize, 2 * blockSize, 48, 48));
					blocks.get(48).add(new Block(48* blockSize, 13 * blockSize, 48, 48));
					blocks.get(48).add(new Block(48* blockSize, 2 * blockSize, 48, 48));
					blocks.get(49).add(new Block(49* blockSize, 13 * blockSize, 48, 48));
					blocks.get(49).add(new Block(49* blockSize, 2 * blockSize, 48, 48));
					blocks.get(50).add(new Block(50* blockSize, 13 * blockSize, 48, 48));
					blocks.get(50).add(new Block(50* blockSize, 2 * blockSize, 48, 48));
					blocks.get(51).add(new Block(51* blockSize, 11 * blockSize, 48, 48));
					blocks.get(51).add(new Block(51* blockSize, 13 * blockSize, 48, 48));
					blocks.get(51).add(new Block(51* blockSize, 2 * blockSize, 48, 48));
					blocks.get(52).add(new Block(52* blockSize, 11 * blockSize, 48, 48));
					blocks.get(52).add(new Block(52* blockSize, 13 * blockSize, 48, 48));
					blocks.get(52).add(new Block(52* blockSize, 2 * blockSize, 48, 48));
					blocks.get(53).add(new Block(53* blockSize, 13 * blockSize, 48, 48));
					blocks.get(53).add(new Block(53* blockSize, 2 * blockSize, 48, 48));
					blocks.get(54).add(new Block(54* blockSize, 13 * blockSize, 48, 48));
					blocks.get(54).add(new Block(54* blockSize, 2 * blockSize, 48, 48));
					blocks.get(55).add(new Block(55* blockSize, 10 * blockSize, 48, 48));
					blocks.get(55).add(new Block(55* blockSize, 13 * blockSize, 48, 48));
					blocks.get(55).add(new Block(55* blockSize, 2 * blockSize, 48, 48));
					blocks.get(56).add(new Block(56* blockSize, 10 * blockSize, 48, 48));
					blocks.get(56).add(new Block(56* blockSize, 13 * blockSize, 48, 48));
					blocks.get(56).add(new Block(56* blockSize, 2 * blockSize, 48, 48));
					blocks.get(57).add(new Block(57* blockSize, 10 * blockSize, 48, 48));
					blocks.get(57).add(new Block(57* blockSize, 13 * blockSize, 48, 48));
					blocks.get(57).add(new Block(57* blockSize, 2 * blockSize, 48, 48));
					blocks.get(58).add(new Block(58* blockSize, 13 * blockSize, 48, 48));
					blocks.get(58).add(new Block(58* blockSize, 2 * blockSize, 48, 48));
					blocks.get(59).add(new Block(59* blockSize, 13 * blockSize, 48, 48));
					blocks.get(59).add(new Block(59* blockSize, 2 * blockSize, 48, 48));
					blocks.get(60).add(new Block(60* blockSize, 9 * blockSize, 48, 48));
					blocks.get(60).add(new Block(60* blockSize, 10 * blockSize, 48, 48));
					blocks.get(60).add(new Block(60* blockSize, 11 * blockSize, 48, 48));
					blocks.get(60).add(new Block(60* blockSize, 12 * blockSize, 48, 48));
					blocks.get(60).add(new Block(60* blockSize, 13 * blockSize, 48, 48));
					blocks.get(60).add(new Block(60* blockSize, 2 * blockSize, 48, 48));
					blocks.get(61).add(new Block(61* blockSize, 9 * blockSize, 48, 48));
					blocks.get(61).add(new Block(61* blockSize, 12 * blockSize, 48, 48));
					blocks.get(61).add(new Block(61* blockSize, 11 * blockSize, 48, 48));
					blocks.get(61).add(new Block(61* blockSize, 10 * blockSize, 48, 48));
					blocks.get(61).add(new Block(61* blockSize, 13 * blockSize, 48, 48));
					blocks.get(61).add(new Block(61* blockSize, 2 * blockSize, 48, 48));
					blocks.get(62).add(new Block(62* blockSize, 9 * blockSize, 48, 48));
					blocks.get(62).add(new Block(62* blockSize, 10 * blockSize, 48, 48));
					blocks.get(62).add(new Block(62* blockSize, 11 * blockSize, 48, 48));
					blocks.get(62).add(new Block(62* blockSize, 12 * blockSize, 48, 48));
					blocks.get(62).add(new Block(62* blockSize, 13 * blockSize, 48, 48));
					blocks.get(62).add(new Block(62* blockSize, 2 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 8 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 9 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 10 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 11 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 12 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 13 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 2 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 8 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 12 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 11 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 10 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 9 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 13 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 2 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 8 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 9 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 10 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 11 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 12 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 13 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 2 * blockSize, 48, 48));
					blocks.get(66).add(new Block(66* blockSize, 8 * blockSize, 48, 48));
					blocks.get(66).add(new Block(66* blockSize, 13 * blockSize, 48, 48));
					blocks.get(66).add(new Block(66* blockSize, 2 * blockSize, 48, 48));
					blocks.get(67).add(new Block(67* blockSize, 8 * blockSize, 48, 48));
					blocks.get(67).add(new Block(67* blockSize, 13 * blockSize, 48, 48));
					blocks.get(67).add(new Block(67* blockSize, 2 * blockSize, 48, 48));
					blocks.get(68).add(new Block(68* blockSize, 8 * blockSize, 48, 48));
					blocks.get(68).add(new Block(68* blockSize, 13 * blockSize, 48, 48));
					blocks.get(68).add(new Block(68* blockSize, 2 * blockSize, 48, 48));
					blocks.get(69).add(new Block(69* blockSize, 8 * blockSize, 48, 48));
					blocks.get(69).add(new Block(69* blockSize, 13 * blockSize, 48, 48));
					blocks.get(69).add(new Block(69* blockSize, 2 * blockSize, 48, 48));
					blocks.get(70).add(new Block(70* blockSize, 8 * blockSize, 48, 48));
					blocks.get(70).add(new Block(70* blockSize, 13 * blockSize, 48, 48));
					blocks.get(70).add(new Block(70* blockSize, 2 * blockSize, 48, 48));
					blocks.get(71).add(new Block(71* blockSize, 8 * blockSize, 48, 48));
					blocks.get(71).add(new Block(71* blockSize, 13 * blockSize, 48, 48));
					blocks.get(71).add(new Block(71* blockSize, 2 * blockSize, 48, 48));
					blocks.get(72).add(new Block(72* blockSize, 13 * blockSize, 48, 48));
					blocks.get(72).add(new Block(72* blockSize, 2 * blockSize, 48, 48));
					blocks.get(73).add(new Block(73* blockSize, 13 * blockSize, 48, 48));
					blocks.get(73).add(new Block(73* blockSize, 2 * blockSize, 48, 48));
					blocks.get(74).add(new Block(74* blockSize, 13 * blockSize, 48, 48));
					blocks.get(74).add(new Block(74* blockSize, 2 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 7 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 8 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 9 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 10 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 11 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 12 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 13 * blockSize, 48, 48));
					blocks.get(75).add(new Block(75* blockSize, 2 * blockSize, 48, 48));
					blocks.get(76).add(new Block(76* blockSize, 7 * blockSize, 48, 48));
					blocks.get(76).add(new Block(76* blockSize, 13 * blockSize, 48, 48));
					blocks.get(76).add(new Block(76* blockSize, 2 * blockSize, 48, 48));
					blocks.get(77).add(new Block(77* blockSize, 7 * blockSize, 48, 48));
					blocks.get(77).add(new Block(77* blockSize, 13 * blockSize, 48, 48));
					blocks.get(77).add(new Block(77* blockSize, 2 * blockSize, 48, 48));
					blocks.get(78).add(new Block(78* blockSize, 7 * blockSize, 48, 48));
					blocks.get(78).add(new Block(78* blockSize, 13 * blockSize, 48, 48));
					blocks.get(78).add(new Block(78* blockSize, 2 * blockSize, 48, 48));
					blocks.get(79).add(new Block(79* blockSize, 7 * blockSize, 48, 48));
					blocks.get(79).add(new Block(79* blockSize, 13 * blockSize, 48, 48));
					blocks.get(79).add(new Block(79* blockSize, 2 * blockSize, 48, 48));
					blocks.get(80).add(new Block(80* blockSize, 7 * blockSize, 48, 48));
					blocks.get(80).add(new Block(80* blockSize, 13 * blockSize, 48, 48));
					blocks.get(80).add(new Block(80* blockSize, 2 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 7 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 13 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 2 * blockSize, 48, 48));
					blocks.get(82).add(new Block(82* blockSize, 7 * blockSize, 48, 48));
					blocks.get(82).add(new Block(82* blockSize, 13 * blockSize, 48, 48));
					blocks.get(82).add(new Block(82* blockSize, 2 * blockSize, 48, 48));
					blocks.get(83).add(new Block(83* blockSize, 7 * blockSize, 48, 48));
					blocks.get(83).add(new Block(83* blockSize, 13 * blockSize, 48, 48));
					blocks.get(83).add(new Block(83* blockSize, 2 * blockSize, 48, 48));
					blocks.get(84).add(new Block(84* blockSize, 7 * blockSize, 48, 48));
					blocks.get(84).add(new Block(84* blockSize, 13 * blockSize, 48, 48));
					blocks.get(84).add(new Block(84* blockSize, 2 * blockSize, 48, 48));
					blocks.get(85).add(new Block(85* blockSize, 8 * blockSize, 48, 48));
					blocks.get(85).add(new Block(85* blockSize, 13 * blockSize, 48, 48));
					blocks.get(85).add(new Block(85* blockSize, 2 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 9 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 13 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 2 * blockSize, 48, 48));
					blocks.get(87).add(new Block(87* blockSize, 10 * blockSize, 48, 48));
					blocks.get(87).add(new Block(87* blockSize, 3 * blockSize, 48, 48));
					blocks.get(87).add(new Block(87* blockSize, 13 * blockSize, 48, 48));
					blocks.get(87).add(new Block(87* blockSize, 2 * blockSize, 48, 48));
					blocks.get(88).add(new Block(88* blockSize, 11 * blockSize, 48, 48));
					blocks.get(88).add(new Block(88* blockSize, 4 * blockSize, 48, 48));
					blocks.get(88).add(new Block(88* blockSize, 13 * blockSize, 48, 48));
					blocks.get(88).add(new Block(88* blockSize, 2 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 12 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 5 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 13 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 2 * blockSize, 48, 48));
					blocks.get(90).add(new Block(90* blockSize, 6 * blockSize, 48, 48));
					blocks.get(90).add(new Block(90* blockSize, 13 * blockSize, 48, 48));
					blocks.get(90).add(new Block(90* blockSize, 2 * blockSize, 48, 48));
					blocks.get(91).add(new Block(91* blockSize, 7 * blockSize, 48, 48));
					blocks.get(91).add(new Block(91* blockSize, 13 * blockSize, 48, 48));
					blocks.get(91).add(new Block(91* blockSize, 2 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 8 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 13 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 2 * blockSize, 48, 48));
					blocks.get(93).add(new Block(93* blockSize, 8 * blockSize, 48, 48));
					blocks.get(93).add(new Block(93* blockSize, 13 * blockSize, 48, 48));
					blocks.get(93).add(new Block(93* blockSize, 2 * blockSize, 48, 48));
					blocks.get(94).add(new Block(94* blockSize, 8 * blockSize, 48, 48));
					blocks.get(94).add(new Block(94* blockSize, 13 * blockSize, 48, 48));
					blocks.get(94).add(new Block(94* blockSize, 2 * blockSize, 48, 48));
					blocks.get(95).add(new Block(95* blockSize, 8 * blockSize, 48, 48));
					blocks.get(95).add(new Block(95* blockSize, 13 * blockSize, 48, 48));
					blocks.get(95).add(new Block(95* blockSize, 2 * blockSize, 48, 48));
					blocks.get(96).add(new Block(96* blockSize, 7 * blockSize, 48, 48));
					blocks.get(96).add(new Block(96* blockSize, 13 * blockSize, 48, 48));
					blocks.get(96).add(new Block(96* blockSize, 2 * blockSize, 48, 48));
					blocks.get(97).add(new Block(97* blockSize, 6 * blockSize, 48, 48));
					blocks.get(97).add(new Block(97* blockSize, 13 * blockSize, 48, 48));
					blocks.get(97).add(new Block(97* blockSize, 2 * blockSize, 48, 48));
					blocks.get(98).add(new Block(98* blockSize, 5 * blockSize, 48, 48));
					blocks.get(98).add(new Block(98* blockSize, 13 * blockSize, 48, 48));
					blocks.get(98).add(new Block(98* blockSize, 2 * blockSize, 48, 48));
					blocks.get(99).add(new Block(99* blockSize, 4 * blockSize, 48, 48));
					blocks.get(99).add(new Block(99* blockSize, 13 * blockSize, 48, 48));
					blocks.get(99).add(new Block(99* blockSize, 2 * blockSize, 48, 48));
					blocks.get(100).add(new Block(100* blockSize, 3 * blockSize, 48, 48));
					blocks.get(100).add(new Block(100* blockSize, 12 * blockSize, 48, 48));
					blocks.get(100).add(new Block(100* blockSize, 13 * blockSize, 48, 48));
					blocks.get(100).add(new Block(100* blockSize, 2 * blockSize, 48, 48));
					blocks.get(101).add(new Block(101* blockSize, 11 * blockSize, 48, 48));
					blocks.get(101).add(new Block(101* blockSize, 13 * blockSize, 48, 48));
					blocks.get(101).add(new Block(101* blockSize, 2 * blockSize, 48, 48));
					blocks.get(102).add(new Block(102* blockSize, 10 * blockSize, 48, 48));
					blocks.get(102).add(new Block(102* blockSize, 13 * blockSize, 48, 48));
					blocks.get(102).add(new Block(102* blockSize, 2 * blockSize, 48, 48));
					blocks.get(103).add(new Block(103* blockSize, 9 * blockSize, 48, 48));
					blocks.get(103).add(new Block(103* blockSize, 13 * blockSize, 48, 48));
					blocks.get(103).add(new Block(103* blockSize, 2 * blockSize, 48, 48));
					blocks.get(104).add(new Block(104* blockSize, 8 * blockSize, 48, 48));
					blocks.get(104).add(new Block(104* blockSize, 13 * blockSize, 48, 48));
					blocks.get(104).add(new Block(104* blockSize, 2 * blockSize, 48, 48));
					blocks.get(105).add(new Block(105* blockSize, 8 * blockSize, 48, 48));
					blocks.get(105).add(new Block(105* blockSize, 13 * blockSize, 48, 48));
					blocks.get(105).add(new Block(105* blockSize, 2 * blockSize, 48, 48));
					blocks.get(106).add(new Block(106* blockSize, 8 * blockSize, 48, 48));
					blocks.get(106).add(new Block(106* blockSize, 13 * blockSize, 48, 48));
					blocks.get(106).add(new Block(106* blockSize, 2 * blockSize, 48, 48));
					blocks.get(107).add(new Block(107* blockSize, 8 * blockSize, 48, 48));
					blocks.get(107).add(new Block(107* blockSize, 13 * blockSize, 48, 48));
					blocks.get(107).add(new Block(107* blockSize, 2 * blockSize, 48, 48));
					blocks.get(108).add(new Block(108* blockSize, 8 * blockSize, 48, 48));
					blocks.get(108).add(new Block(108* blockSize, 13 * blockSize, 48, 48));
					blocks.get(108).add(new Block(108* blockSize, 2 * blockSize, 48, 48));
					blocks.get(109).add(new Block(109* blockSize, 8 * blockSize, 48, 48));
					blocks.get(109).add(new Block(109* blockSize, 13 * blockSize, 48, 48));
					blocks.get(109).add(new Block(109* blockSize, 2 * blockSize, 48, 48));
					blocks.get(110).add(new Block(110* blockSize, 8 * blockSize, 48, 48));
					blocks.get(110).add(new Block(110* blockSize, 13 * blockSize, 48, 48));
					blocks.get(110).add(new Block(110* blockSize, 2 * blockSize, 48, 48));
					blocks.get(111).add(new Block(111* blockSize, 8 * blockSize, 48, 48));
					blocks.get(111).add(new Block(111* blockSize, 13 * blockSize, 48, 48));
					blocks.get(111).add(new Block(111* blockSize, 2 * blockSize, 48, 48));
					blocks.get(112).add(new Block(112* blockSize, 7 * blockSize, 48, 48));
					blocks.get(112).add(new Block(112* blockSize, 13 * blockSize, 48, 48));
					blocks.get(112).add(new Block(112* blockSize, 2 * blockSize, 48, 48));
					blocks.get(113).add(new Block(113* blockSize, 7 * blockSize, 48, 48));
					blocks.get(113).add(new Block(113* blockSize, 6 * blockSize, 48, 48));
					blocks.get(113).add(new Block(113* blockSize, 13 * blockSize, 48, 48));
					blocks.get(113).add(new Block(113* blockSize, 2 * blockSize, 48, 48));
					blocks.get(114).add(new Block(114* blockSize, 6 * blockSize, 48, 48));
					blocks.get(114).add(new Block(114* blockSize, 13 * blockSize, 48, 48));
					blocks.get(114).add(new Block(114* blockSize, 2 * blockSize, 48, 48));
					blocks.get(115).add(new Block(115* blockSize, 6 * blockSize, 48, 48));
					blocks.get(115).add(new Block(115* blockSize, 13 * blockSize, 48, 48));
					blocks.get(115).add(new Block(115* blockSize, 2 * blockSize, 48, 48));
					blocks.get(116).add(new Block(116* blockSize, 6 * blockSize, 48, 48));
					blocks.get(116).add(new Block(116* blockSize, 13 * blockSize, 48, 48));
					blocks.get(116).add(new Block(116* blockSize, 2 * blockSize, 48, 48));
					blocks.get(117).add(new Block(117* blockSize, 13 * blockSize, 48, 48));
					blocks.get(117).add(new Block(117* blockSize, 2 * blockSize, 48, 48));
					blocks.get(118).add(new Block(118* blockSize, 13 * blockSize, 48, 48));
					blocks.get(118).add(new Block(118* blockSize, 2 * blockSize, 48, 48));
					blocks.get(119).add(new Block(119* blockSize, 13 * blockSize, 48, 48));
					blocks.get(119).add(new Block(119* blockSize, 2 * blockSize, 48, 48));
					blocks.get(120).add(new Block(120* blockSize, 13 * blockSize, 48, 48));
					blocks.get(120).add(new Block(120* blockSize, 2 * blockSize, 48, 48));
					blocks.get(121).add(new Block(121* blockSize, 13 * blockSize, 48, 48));
					blocks.get(121).add(new Block(121* blockSize, 2 * blockSize, 48, 48));
					blocks.get(122).add(new Block(122* blockSize, 13 * blockSize, 48, 48));
					blocks.get(122).add(new Block(122* blockSize, 2 * blockSize, 48, 48));
					blocks.get(123).add(new Block(123* blockSize, 13 * blockSize, 48, 48));
					blocks.get(123).add(new Block(123* blockSize, 2 * blockSize, 48, 48));
					blocks.get(124).add(new Block(124* blockSize, 13 * blockSize, 48, 48));
					blocks.get(124).add(new Block(124* blockSize, 2 * blockSize, 48, 48));
					blocks.get(125).add(new Block(125* blockSize, 13 * blockSize, 48, 48));
					blocks.get(125).add(new Block(125* blockSize, 2 * blockSize, 48, 48));
					blocks.get(126).add(new Block(126* blockSize, 13 * blockSize, 48, 48));
					blocks.get(126).add(new Block(126* blockSize, 2 * blockSize, 48, 48));
					blocks.get(127).add(new Block(127* blockSize, 13 * blockSize, 48, 48));
					blocks.get(127).add(new Block(127* blockSize, 2 * blockSize, 48, 48));
					blocks.get(128).add(new Block(128* blockSize, 13 * blockSize, 48, 48));
					blocks.get(128).add(new Block(128* blockSize, 2 * blockSize, 48, 48));
					blocks.get(129).add(new Block(129* blockSize, 13 * blockSize, 48, 48));
					blocks.get(129).add(new Block(129* blockSize, 2 * blockSize, 48, 48));
					blocks.get(130).add(new Block(130* blockSize, 13 * blockSize, 48, 48));
					blocks.get(130).add(new Block(130* blockSize, 2 * blockSize, 48, 48));
					blocks.get(131).add(new Block(131* blockSize, 13 * blockSize, 48, 48));
					blocks.get(131).add(new Block(131* blockSize, 2 * blockSize, 48, 48));
					blocks.get(132).add(new Block(132* blockSize, 13 * blockSize, 48, 48));
					blocks.get(132).add(new Block(132* blockSize, 2 * blockSize, 48, 48));
					blocks.get(133).add(new Block(133* blockSize, 13 * blockSize, 48, 48));
					blocks.get(133).add(new Block(133* blockSize, 2 * blockSize, 48, 48));
					blocks.get(134).add(new Block(134* blockSize, 13 * blockSize, 48, 48));
					blocks.get(134).add(new Block(134* blockSize, 2 * blockSize, 48, 48));
					blocks.get(135).add(new Block(135* blockSize, 13 * blockSize, 48, 48));
					blocks.get(135).add(new Block(135* blockSize, 2 * blockSize, 48, 48));
					blocks.get(136).add(new Block(136* blockSize, 13 * blockSize, 48, 48));
					blocks.get(136).add(new Block(136* blockSize, 2 * blockSize, 48, 48));
					blocks.get(137).add(new Block(137* blockSize, 11 * blockSize, 48, 48));
					blocks.get(137).add(new Block(137* blockSize, 13 * blockSize, 48, 48));
					blocks.get(137).add(new Block(137* blockSize, 2 * blockSize, 48, 48));
					blocks.get(138).add(new Block(138* blockSize, 11 * blockSize, 48, 48));
					blocks.get(138).add(new Block(138* blockSize, 13 * blockSize, 48, 48));
					blocks.get(138).add(new Block(138* blockSize, 2 * blockSize, 48, 48));
					blocks.get(139).add(new Block(139* blockSize, 13 * blockSize, 48, 48));
					blocks.get(139).add(new Block(139* blockSize, 2 * blockSize, 48, 48));
					blocks.get(140).add(new Block(140* blockSize, 10 * blockSize, 48, 48));
					blocks.get(140).add(new Block(140* blockSize, 13 * blockSize, 48, 48));
					blocks.get(140).add(new Block(140* blockSize, 2 * blockSize, 48, 48));
					blocks.get(141).add(new Block(141* blockSize, 10 * blockSize, 48, 48));
					blocks.get(141).add(new Block(141* blockSize, 13 * blockSize, 48, 48));
					blocks.get(141).add(new Block(141* blockSize, 2 * blockSize, 48, 48));
					blocks.get(142).add(new Block(142* blockSize, 10 * blockSize, 48, 48));
					blocks.get(142).add(new Block(142* blockSize, 13 * blockSize, 48, 48));
					blocks.get(142).add(new Block(142* blockSize, 2 * blockSize, 48, 48));
					blocks.get(143).add(new Block(143* blockSize, 13 * blockSize, 48, 48));
					blocks.get(143).add(new Block(143* blockSize, 2 * blockSize, 48, 48));
					blocks.get(144).add(new Block(144* blockSize, 13 * blockSize, 48, 48));
					blocks.get(144).add(new Block(144* blockSize, 2 * blockSize, 48, 48));
					blocks.get(145).add(new Block(145* blockSize, 13 * blockSize, 48, 48));
					blocks.get(145).add(new Block(145* blockSize, 2 * blockSize, 48, 48));
					blocks.get(146).add(new Block(146* blockSize, 13 * blockSize, 48, 48));
					blocks.get(146).add(new Block(146* blockSize, 2 * blockSize, 48, 48));
					blocks.get(147).add(new Block(147* blockSize, 13 * blockSize, 48, 48));
					blocks.get(147).add(new Block(147* blockSize, 2 * blockSize, 48, 48));
					blocks.get(148).add(new Block(148* blockSize, 13 * blockSize, 48, 48));
					blocks.get(148).add(new Block(148* blockSize, 2 * blockSize, 48, 48));
					blocks.get(149).add(new Block(149* blockSize, 13 * blockSize, 48, 48));
					blocks.get(149).add(new Block(149* blockSize, 2 * blockSize, 48, 48));
					blocks.get(150).add(new Block(150* blockSize, 12 * blockSize, 48, 48));
					blocks.get(150).add(new Block(150* blockSize, 11 * blockSize, 48, 48));
					blocks.get(150).add(new Block(150* blockSize, 10 * blockSize, 48, 48));
					blocks.get(150).add(new Block(150* blockSize, 9 * blockSize, 48, 48));
					blocks.get(150).add(new Block(150* blockSize, 8 * blockSize, 48, 48));
					blocks.get(150).add(new Block(150* blockSize, 13 * blockSize, 48, 48));
					blocks.get(150).add(new Block(150* blockSize, 2 * blockSize, 48, 48));
					blocks.get(151).add(new Block(151* blockSize, 13 * blockSize, 48, 48));
					blocks.get(151).add(new Block(151* blockSize, 2 * blockSize, 48, 48));
					blocks.get(152).add(new Block(152* blockSize, 13 * blockSize, 48, 48));
					blocks.get(152).add(new Block(152* blockSize, 2 * blockSize, 48, 48));
					blocks.get(153).add(new Block(153* blockSize, 13 * blockSize, 48, 48));
					blocks.get(153).add(new Block(153* blockSize, 2 * blockSize, 48, 48));
					blocks.get(154).add(new Block(154* blockSize, 3 * blockSize, 48, 48));
					blocks.get(154).add(new Block(154* blockSize, 4 * blockSize, 48, 48));
					blocks.get(154).add(new Block(154* blockSize, 5 * blockSize, 48, 48));
					blocks.get(154).add(new Block(154* blockSize, 6 * blockSize, 48, 48));
					blocks.get(154).add(new Block(154* blockSize, 7 * blockSize, 48, 48));
					blocks.get(154).add(new Block(154* blockSize, 13 * blockSize, 48, 48));
					blocks.get(154).add(new Block(154* blockSize, 2 * blockSize, 48, 48));
					blocks.get(155).add(new Block(155* blockSize, 13 * blockSize, 48, 48));
					blocks.get(155).add(new Block(155* blockSize, 2 * blockSize, 48, 48));
					blocks.get(156).add(new Block(156* blockSize, 13 * blockSize, 48, 48));
					blocks.get(156).add(new Block(156* blockSize, 2 * blockSize, 48, 48));
					blocks.get(157).add(new Block(157* blockSize, 13 * blockSize, 48, 48));
					blocks.get(157).add(new Block(157* blockSize, 2 * blockSize, 48, 48));
					blocks.get(158).add(new Block(158* blockSize, 13 * blockSize, 48, 48));
					blocks.get(158).add(new Block(158* blockSize, 2 * blockSize, 48, 48));
					blocks.get(159).add(new Block(159* blockSize, 13 * blockSize, 48, 48));
					blocks.get(159).add(new Block(159* blockSize, 2 * blockSize, 48, 48));
					blocks.get(160).add(new Block(160* blockSize, 13 * blockSize, 48, 48));
					blocks.get(160).add(new Block(160* blockSize, 2 * blockSize, 48, 48));
					blocks.get(161).add(new Block(161* blockSize, 13 * blockSize, 48, 48));
					blocks.get(161).add(new Block(161* blockSize, 2 * blockSize, 48, 48));
					blocks.get(162).add(new Block(162* blockSize, 13 * blockSize, 48, 48));
					blocks.get(162).add(new Block(162* blockSize, 2 * blockSize, 48, 48));
					blocks.get(163).add(new Block(163* blockSize, 13 * blockSize, 48, 48));
					blocks.get(163).add(new Block(163* blockSize, 2 * blockSize, 48, 48));
					blocks.get(164).add(new Block(164* blockSize, 13 * blockSize, 48, 48));
					blocks.get(164).add(new Block(164* blockSize, 2 * blockSize, 48, 48));
					blocks.get(165).add(new Block(165* blockSize, 13 * blockSize, 48, 48));
					blocks.get(165).add(new Block(165* blockSize, 2 * blockSize, 48, 48));
					blocks.get(166).add(new Block(166* blockSize, 13 * blockSize, 48, 48));
					blocks.get(166).add(new Block(166* blockSize, 2 * blockSize, 48, 48));
					blocks.get(167).add(new Block(167* blockSize, 13 * blockSize, 48, 48));
					blocks.get(167).add(new Block(167* blockSize, 2 * blockSize, 48, 48));
					blocks.get(168).add(new Block(168* blockSize, 6 * blockSize, 48, 48));
					blocks.get(168).add(new Block(168* blockSize, 13 * blockSize, 48, 48));
					blocks.get(168).add(new Block(168* blockSize, 2 * blockSize, 48, 48));
					blocks.get(169).add(new Block(169* blockSize, 6 * blockSize, 48, 48));
					blocks.get(169).add(new Block(169* blockSize, 13 * blockSize, 48, 48));
					blocks.get(169).add(new Block(169* blockSize, 2 * blockSize, 48, 48));
					blocks.get(170).add(new Block(170* blockSize, 6 * blockSize, 48, 48));
					blocks.get(170).add(new Block(170* blockSize, 7 * blockSize, 48, 48));
					blocks.get(170).add(new Block(170* blockSize, 13 * blockSize, 48, 48));
					blocks.get(170).add(new Block(170* blockSize, 2 * blockSize, 48, 48));
					blocks.get(171).add(new Block(171* blockSize, 7 * blockSize, 48, 48));
					blocks.get(171).add(new Block(171* blockSize, 13 * blockSize, 48, 48));
					blocks.get(171).add(new Block(171* blockSize, 2 * blockSize, 48, 48));
					blocks.get(172).add(new Block(172* blockSize, 7 * blockSize, 48, 48));
					blocks.get(172).add(new Block(172* blockSize, 13 * blockSize, 48, 48));
					blocks.get(172).add(new Block(172* blockSize, 2 * blockSize, 48, 48));
					blocks.get(173).add(new Block(173* blockSize, 7 * blockSize, 48, 48));
					blocks.get(173).add(new Block(173* blockSize, 13 * blockSize, 48, 48));
					blocks.get(173).add(new Block(173* blockSize, 2 * blockSize, 48, 48));
					blocks.get(174).add(new Block(174* blockSize, 13 * blockSize, 48, 48));
					blocks.get(174).add(new Block(174* blockSize, 2 * blockSize, 48, 48));
					blocks.get(175).add(new Block(175* blockSize, 13 * blockSize, 48, 48));
					blocks.get(175).add(new Block(175* blockSize, 2 * blockSize, 48, 48));
					blocks.get(176).add(new Block(176* blockSize, 13 * blockSize, 48, 48));
					blocks.get(176).add(new Block(176* blockSize, 2 * blockSize, 48, 48));
					blocks.get(177).add(new Block(177* blockSize, 12 * blockSize, 48, 48));
					blocks.get(177).add(new Block(177* blockSize, 13 * blockSize, 48, 48));
					blocks.get(177).add(new Block(177* blockSize, 2 * blockSize, 48, 48));
					blocks.get(178).add(new Block(178* blockSize, 12 * blockSize, 48, 48));
					blocks.get(178).add(new Block(178* blockSize, 13 * blockSize, 48, 48));
					blocks.get(178).add(new Block(178* blockSize, 2 * blockSize, 48, 48));
					blocks.get(179).add(new Block(179* blockSize, 12 * blockSize, 48, 48));
					blocks.get(179).add(new Block(179* blockSize, 13 * blockSize, 48, 48));
					blocks.get(179).add(new Block(179* blockSize, 2 * blockSize, 48, 48));
					blocks.get(180).add(new Block(180* blockSize, 7 * blockSize, 48, 48));
					blocks.get(180).add(new Block(180* blockSize, 12 * blockSize, 48, 48));
					blocks.get(180).add(new Block(180* blockSize, 13 * blockSize, 48, 48));
					blocks.get(180).add(new Block(180* blockSize, 2 * blockSize, 48, 48));
					blocks.get(181).add(new Block(181* blockSize, 7 * blockSize, 48, 48));
					blocks.get(181).add(new Block(181* blockSize, 12 * blockSize, 48, 48));
					blocks.get(181).add(new Block(181* blockSize, 13 * blockSize, 48, 48));
					blocks.get(181).add(new Block(181* blockSize, 2 * blockSize, 48, 48));
					blocks.get(182).add(new Block(182* blockSize, 6 * blockSize, 48, 48));
					blocks.get(182).add(new Block(182* blockSize, 12 * blockSize, 48, 48));
					blocks.get(182).add(new Block(182* blockSize, 13 * blockSize, 48, 48));
					blocks.get(182).add(new Block(182* blockSize, 2 * blockSize, 48, 48));
					blocks.get(183).add(new Block(183* blockSize, 6 * blockSize, 48, 48));
					blocks.get(183).add(new Block(183* blockSize, 5 * blockSize, 48, 48));
					blocks.get(183).add(new Block(183* blockSize, 12 * blockSize, 48, 48));
					blocks.get(183).add(new Block(183* blockSize, 13 * blockSize, 48, 48));
					blocks.get(183).add(new Block(183* blockSize, 2 * blockSize, 48, 48));
					blocks.get(184).add(new Block(184* blockSize, 5 * blockSize, 48, 48));
					blocks.get(184).add(new Block(184* blockSize, 4 * blockSize, 48, 48));
					blocks.get(184).add(new Block(184* blockSize, 12 * blockSize, 48, 48));
					blocks.get(184).add(new Block(184* blockSize, 13 * blockSize, 48, 48));
					blocks.get(184).add(new Block(184* blockSize, 2 * blockSize, 48, 48));
					blocks.get(185).add(new Block(185* blockSize, 4 * blockSize, 48, 48));
					blocks.get(185).add(new Block(185* blockSize, 3 * blockSize, 48, 48));
					blocks.get(185).add(new Block(185* blockSize, 11 * blockSize, 48, 48));
					blocks.get(185).add(new Block(185* blockSize, 13 * blockSize, 48, 48));
					blocks.get(185).add(new Block(185* blockSize, 2 * blockSize, 48, 48));
					blocks.get(186).add(new Block(186* blockSize, 11 * blockSize, 48, 48));
					blocks.get(186).add(new Block(186* blockSize, 10 * blockSize, 48, 48));
					blocks.get(186).add(new Block(186* blockSize, 13 * blockSize, 48, 48));
					blocks.get(186).add(new Block(186* blockSize, 2 * blockSize, 48, 48));
					blocks.get(187).add(new Block(187* blockSize, 10 * blockSize, 48, 48));
					blocks.get(187).add(new Block(187* blockSize, 13 * blockSize, 48, 48));
					blocks.get(187).add(new Block(187* blockSize, 2 * blockSize, 48, 48));
					blocks.get(188).add(new Block(188* blockSize, 10 * blockSize, 48, 48));
					blocks.get(188).add(new Block(188* blockSize, 9 * blockSize, 48, 48));
					blocks.get(188).add(new Block(188* blockSize, 13 * blockSize, 48, 48));
					blocks.get(188).add(new Block(188* blockSize, 2 * blockSize, 48, 48));
					blocks.get(189).add(new Block(189* blockSize, 9 * blockSize, 48, 48));
					blocks.get(189).add(new Block(189* blockSize, 13 * blockSize, 48, 48));
					blocks.get(189).add(new Block(189* blockSize, 2 * blockSize, 48, 48));
					blocks.get(190).add(new Block(190* blockSize, 9 * blockSize, 48, 48));
					blocks.get(190).add(new Block(190* blockSize, 3 * blockSize, 48, 48));
					blocks.get(190).add(new Block(190* blockSize, 13 * blockSize, 48, 48));
					blocks.get(190).add(new Block(190* blockSize, 2 * blockSize, 48, 48));
					blocks.get(191).add(new Block(191* blockSize, 9 * blockSize, 48, 48));
					blocks.get(191).add(new Block(191* blockSize, 3 * blockSize, 48, 48));
					blocks.get(191).add(new Block(191* blockSize, 13 * blockSize, 48, 48));
					blocks.get(191).add(new Block(191* blockSize, 2 * blockSize, 48, 48));
					blocks.get(192).add(new Block(192* blockSize, 9 * blockSize, 48, 48));
					blocks.get(192).add(new Block(192* blockSize, 4 * blockSize, 48, 48));
					blocks.get(192).add(new Block(192* blockSize, 13 * blockSize, 48, 48));
					blocks.get(192).add(new Block(192* blockSize, 2 * blockSize, 48, 48));
					blocks.get(193).add(new Block(193* blockSize, 9 * blockSize, 48, 48));
					blocks.get(193).add(new Block(193* blockSize, 4 * blockSize, 48, 48));
					blocks.get(193).add(new Block(193* blockSize, 13 * blockSize, 48, 48));
					blocks.get(193).add(new Block(193* blockSize, 2 * blockSize, 48, 48));
					blocks.get(194).add(new Block(194* blockSize, 9 * blockSize, 48, 48));
					blocks.get(194).add(new Block(194* blockSize, 5 * blockSize, 48, 48));
					blocks.get(194).add(new Block(194* blockSize, 13 * blockSize, 48, 48));
					blocks.get(194).add(new Block(194* blockSize, 2 * blockSize, 48, 48));
					blocks.get(195).add(new Block(195* blockSize, 9 * blockSize, 48, 48));
					blocks.get(195).add(new Block(195* blockSize, 5 * blockSize, 48, 48));
					blocks.get(195).add(new Block(195* blockSize, 13 * blockSize, 48, 48));
					blocks.get(195).add(new Block(195* blockSize, 2 * blockSize, 48, 48));
					blocks.get(196).add(new Block(196* blockSize, 5 * blockSize, 48, 48));
					blocks.get(196).add(new Block(196* blockSize, 9 * blockSize, 48, 48));
					blocks.get(196).add(new Block(196* blockSize, 13 * blockSize, 48, 48));
					blocks.get(196).add(new Block(196* blockSize, 2 * blockSize, 48, 48));
					blocks.get(197).add(new Block(197* blockSize, 5 * blockSize, 48, 48));
					blocks.get(197).add(new Block(197* blockSize, 9 * blockSize, 48, 48));
					blocks.get(197).add(new Block(197* blockSize, 13 * blockSize, 48, 48));
					blocks.get(197).add(new Block(197* blockSize, 2 * blockSize, 48, 48));
					blocks.get(198).add(new Block(198* blockSize, 13 * blockSize, 48, 48));
					blocks.get(198).add(new Block(198* blockSize, 2 * blockSize, 48, 48));
					blocks.get(199).add(new Block(199* blockSize, 13 * blockSize, 48, 48));
					blocks.get(199).add(new Block(199* blockSize, 2 * blockSize, 48, 48));
					blocks.get(200).add(new Block(200* blockSize, 13 * blockSize, 48, 48));
					blocks.get(200).add(new Block(200* blockSize, 2 * blockSize, 48, 48));
					blocks.get(201).add(new Block(201* blockSize, 13 * blockSize, 48, 48));
					blocks.get(201).add(new Block(201* blockSize, 2 * blockSize, 48, 48));
					blocks.get(202).add(new Block(202* blockSize, 13 * blockSize, 48, 48));
					blocks.get(202).add(new Block(202* blockSize, 2 * blockSize, 48, 48));
					blocks.get(203).add(new Block(203* blockSize, 13 * blockSize, 48, 48));
					blocks.get(203).add(new Block(203* blockSize, 2 * blockSize, 48, 48));
					blocks.get(204).add(new Block(204* blockSize, 13 * blockSize, 48, 48));
					blocks.get(204).add(new Block(204* blockSize, 2 * blockSize, 48, 48));
					blocks.get(205).add(new Block(205* blockSize, 3 * blockSize, 48, 48));
					blocks.get(205).add(new Block(205* blockSize, 4 * blockSize, 48, 48));
					blocks.get(205).add(new Block(205* blockSize, 5 * blockSize, 48, 48));
					blocks.get(205).add(new Block(205* blockSize, 6 * blockSize, 48, 48));
					blocks.get(205).add(new Block(205* blockSize, 13 * blockSize, 48, 48));
					blocks.get(205).add(new Block(205* blockSize, 2 * blockSize, 48, 48));
					blocks.get(206).add(new Block(206* blockSize, 13 * blockSize, 48, 48));
					blocks.get(206).add(new Block(206* blockSize, 2 * blockSize, 48, 48));
					blocks.get(207).add(new Block(207* blockSize, 13 * blockSize, 48, 48));
					blocks.get(207).add(new Block(207* blockSize, 2 * blockSize, 48, 48));
					blocks.get(208).add(new Block(208* blockSize, 13 * blockSize, 48, 48));
					blocks.get(208).add(new Block(208* blockSize, 2 * blockSize, 48, 48));
					blocks.get(209).add(new Block(209* blockSize, 13 * blockSize, 48, 48));
					blocks.get(209).add(new Block(209* blockSize, 2 * blockSize, 48, 48));
					spikes.get(69).add(new Spike(69* blockSize, 7 * blockSize, 48, 48));
					spikes.get(70).add(new Spike(70* blockSize, 7 * blockSize, 48, 48));
					spikes.get(132).add(new Spike(132* blockSize, 12 * blockSize, 48, 48));
					spikes.get(140).add(new Spike(140* blockSize, 12 * blockSize, 48, 48));
					spikes.get(141).add(new Spike(141* blockSize, 12 * blockSize, 48, 48));
					spikes.get(142).add(new Spike(142* blockSize, 9 * blockSize, 48, 48));
					spikes.get(157).add(new Spike(157* blockSize, 12 * blockSize, 48, 48));
					spikes.get(158).add(new Spike(158* blockSize, 12 * blockSize, 48, 48));
					spikes.get(161).add(new Spike(161* blockSize, 3 * blockSize, 48, 48));
					spikes.get(162).add(new Spike(162* blockSize, 3 * blockSize, 48, 48));
					spikes.get(166).add(new Spike(166* blockSize, 12 * blockSize, 48, 48));
					spikes.get(167).add(new Spike(167* blockSize, 12 * blockSize, 48, 48));
					spikes.get(174).add(new Spike(174* blockSize, 12 * blockSize, 48, 48));
					spikes.get(175).add(new Spike(175* blockSize, 12 * blockSize, 48, 48));
					spikes.get(176).add(new Spike(176* blockSize, 12 * blockSize, 48, 48));
					portals.get(6).add(new SpiderP(6* blockSize, 10 * blockSize, 48, 96));
					portals.get(47).add(new CubeP(47* blockSize, 11 * blockSize, 48, 96));
					portals.get(73).add(new FlyP(73* blockSize, 5 * blockSize, 48, 96));
					portals.get(106).add(new ArrowP(106* blockSize, 5 * blockSize, 48, 96));
					portals.get(117).add(new CubeP(117* blockSize, 4 * blockSize, 48, 96));
					portals.get(143).add(new SpiderP(143* blockSize, 7 * blockSize, 48, 96));
					portals.get(167).add(new CubeP(167* blockSize, 3 * blockSize, 48, 96));
					portals.get(180).add(new ArrowP(180* blockSize, 10 * blockSize, 48, 96));
					portals.get(198).add(new FlyP(198* blockSize, 6 * blockSize, 48, 96));
					portals.get(198).add(new FlyP(198* blockSize, 7 * blockSize, 48, 96));
			
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				} else if(map == 2) {
					
					for(int i = 0; i < mapSize; i++) {
						
						blocks.get(i).add(new Block(blockSize * i, blockSize * 2, blockSize, blockSize));
						blocks.get(i).add(new Block(blockSize * i, blockSize * 13, blockSize, blockSize));
						
					}
					
					blocks.get(8).add(new Block(8* blockSize, 10 * blockSize, 48, 48));
					blocks.get(9).add(new Block(9* blockSize, 9 * blockSize, 48, 48));
					blocks.get(10).add(new Block(10* blockSize, 8 * blockSize, 48, 48));
					blocks.get(11).add(new Block(11* blockSize, 7 * blockSize, 48, 48));
					blocks.get(11).add(new Block(11* blockSize, 12 * blockSize, 48, 48));
					blocks.get(12).add(new Block(12* blockSize, 6 * blockSize, 48, 48));
					blocks.get(12).add(new Block(12* blockSize, 11 * blockSize, 48, 48));
					blocks.get(13).add(new Block(13* blockSize, 5 * blockSize, 48, 48));
					blocks.get(13).add(new Block(13* blockSize, 10 * blockSize, 48, 48));
					blocks.get(14).add(new Block(14* blockSize, 4 * blockSize, 48, 48));
					blocks.get(14).add(new Block(14* blockSize, 9 * blockSize, 48, 48));
					blocks.get(15).add(new Block(15* blockSize, 3 * blockSize, 48, 48));
					blocks.get(15).add(new Block(15* blockSize, 8 * blockSize, 48, 48));
					blocks.get(16).add(new Block(16* blockSize, 7 * blockSize, 48, 48));
					blocks.get(17).add(new Block(17* blockSize, 7 * blockSize, 48, 48));
					blocks.get(18).add(new Block(18* blockSize, 7 * blockSize, 48, 48));
					blocks.get(19).add(new Block(19* blockSize, 7 * blockSize, 48, 48));
					blocks.get(20).add(new Block(20* blockSize, 7 * blockSize, 48, 48));
					blocks.get(21).add(new Block(21* blockSize, 7 * blockSize, 48, 48));
					blocks.get(22).add(new Block(22* blockSize, 7 * blockSize, 48, 48));
					blocks.get(23).add(new Block(23* blockSize, 8 * blockSize, 48, 48));
					blocks.get(24).add(new Block(24* blockSize, 9 * blockSize, 48, 48));
					blocks.get(25).add(new Block(25* blockSize, 10 * blockSize, 48, 48));
					blocks.get(25).add(new Block(25* blockSize, 3 * blockSize, 48, 48));
					blocks.get(26).add(new Block(26* blockSize, 11 * blockSize, 48, 48));
					blocks.get(26).add(new Block(26* blockSize, 4 * blockSize, 48, 48));
					blocks.get(27).add(new Block(27* blockSize, 12 * blockSize, 48, 48));
					blocks.get(27).add(new Block(27* blockSize, 5 * blockSize, 48, 48));
					blocks.get(28).add(new Block(28* blockSize, 6 * blockSize, 48, 48));
					blocks.get(29).add(new Block(29* blockSize, 7 * blockSize, 48, 48));
					blocks.get(30).add(new Block(30* blockSize, 8 * blockSize, 48, 48));
					blocks.get(31).add(new Block(31* blockSize, 9 * blockSize, 48, 48));
					blocks.get(60).add(new Block(60* blockSize, 9 * blockSize, 48, 48));
					blocks.get(61).add(new Block(61* blockSize, 9 * blockSize, 48, 48));
					blocks.get(62).add(new Block(62* blockSize, 9 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 9 * blockSize, 48, 48));
					blocks.get(63).add(new Block(63* blockSize, 9 * blockSize, 48, 48));
					blocks.get(64).add(new Block(64* blockSize, 9 * blockSize, 48, 48));
					blocks.get(65).add(new Block(65* blockSize, 9 * blockSize, 48, 48));
					blocks.get(68).add(new Block(68* blockSize, 8 * blockSize, 48, 48));
					blocks.get(69).add(new Block(69* blockSize, 8 * blockSize, 48, 48));
					blocks.get(72).add(new Block(72* blockSize, 7 * blockSize, 48, 48));
					blocks.get(73).add(new Block(73* blockSize, 7 * blockSize, 48, 48));
					blocks.get(77).add(new Block(77* blockSize, 9 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 3 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 4 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 5 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 6 * blockSize, 48, 48));
					blocks.get(81).add(new Block(81* blockSize, 7 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 12 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 11 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 10 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 9 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 8 * blockSize, 48, 48));
					blocks.get(86).add(new Block(86* blockSize, 7 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 3 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 4 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 5 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 6 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 7 * blockSize, 48, 48));
					blocks.get(89).add(new Block(89* blockSize, 8 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 12 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 11 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 10 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 9 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 8 * blockSize, 48, 48));
					blocks.get(92).add(new Block(92* blockSize, 7 * blockSize, 48, 48));
					blocks.get(93).add(new Block(93* blockSize, 8 * blockSize, 48, 48));
					blocks.get(94).add(new Block(94* blockSize, 9 * blockSize, 48, 48));
					blocks.get(95).add(new Block(95* blockSize, 10 * blockSize, 48, 48));
					blocks.get(95).add(new Block(95* blockSize, 6 * blockSize, 48, 48));
					blocks.get(96).add(new Block(96* blockSize, 6 * blockSize, 48, 48));
					blocks.get(104).add(new Block(104* blockSize, 5 * blockSize, 48, 48));
					blocks.get(105).add(new Block(105* blockSize, 5 * blockSize, 48, 48));
					blocks.get(106).add(new Block(106* blockSize, 5 * blockSize, 48, 48));
					blocks.get(107).add(new Block(107* blockSize, 6 * blockSize, 48, 48));
					blocks.get(108).add(new Block(108* blockSize, 7 * blockSize, 48, 48));
					blocks.get(108).add(new Block(108* blockSize, 8 * blockSize, 48, 48));
					blocks.get(109).add(new Block(109* blockSize, 3 * blockSize, 48, 48));
					blocks.get(109).add(new Block(109* blockSize, 9 * blockSize, 48, 48));
					blocks.get(110).add(new Block(110* blockSize, 4 * blockSize, 48, 48));
					blocks.get(110).add(new Block(110* blockSize, 10 * blockSize, 48, 48));
					blocks.get(111).add(new Block(111* blockSize, 5 * blockSize, 48, 48));
					blocks.get(111).add(new Block(111* blockSize, 11 * blockSize, 48, 48));
					blocks.get(112).add(new Block(112* blockSize, 6 * blockSize, 48, 48));
					blocks.get(112).add(new Block(112* blockSize, 12 * blockSize, 48, 48));
					blocks.get(113).add(new Block(113* blockSize, 7 * blockSize, 48, 48));
					blocks.get(114).add(new Block(114* blockSize, 8 * blockSize, 48, 48));
					blocks.get(115).add(new Block(115* blockSize, 9 * blockSize, 48, 48));
					blocks.get(116).add(new Block(116* blockSize, 10 * blockSize, 48, 48));
					blocks.get(117).add(new Block(117* blockSize, 9 * blockSize, 48, 48));
					blocks.get(118).add(new Block(118* blockSize, 8 * blockSize, 48, 48));
					blocks.get(119).add(new Block(119* blockSize, 7 * blockSize, 48, 48));
					blocks.get(120).add(new Block(120* blockSize, 6 * blockSize, 48, 48));
					blocks.get(120).add(new Block(120* blockSize, 12 * blockSize, 48, 48));
					blocks.get(121).add(new Block(121* blockSize, 5 * blockSize, 48, 48));
					blocks.get(121).add(new Block(121* blockSize, 11 * blockSize, 48, 48));
					blocks.get(122).add(new Block(122* blockSize, 4 * blockSize, 48, 48));
					blocks.get(122).add(new Block(122* blockSize, 10 * blockSize, 48, 48));
					blocks.get(123).add(new Block(123* blockSize, 3 * blockSize, 48, 48));
					blocks.get(123).add(new Block(123* blockSize, 9 * blockSize, 48, 48));
					blocks.get(124).add(new Block(124* blockSize, 8 * blockSize, 48, 48));
					blocks.get(125).add(new Block(125* blockSize, 7 * blockSize, 48, 48));
					blocks.get(126).add(new Block(126* blockSize, 7 * blockSize, 48, 48));
					blocks.get(127).add(new Block(127* blockSize, 7 * blockSize, 48, 48));
					blocks.get(128).add(new Block(128* blockSize, 8 * blockSize, 48, 48));
					blocks.get(129).add(new Block(129* blockSize, 3 * blockSize, 48, 48));
					blocks.get(129).add(new Block(129* blockSize, 9 * blockSize, 48, 48));
					blocks.get(130).add(new Block(130* blockSize, 4 * blockSize, 48, 48));
					blocks.get(130).add(new Block(130* blockSize, 10 * blockSize, 48, 48));
					blocks.get(131).add(new Block(131* blockSize, 5 * blockSize, 48, 48));
					blocks.get(131).add(new Block(131* blockSize, 11 * blockSize, 48, 48));
					blocks.get(132).add(new Block(132* blockSize, 6 * blockSize, 48, 48));
					blocks.get(132).add(new Block(132* blockSize, 12 * blockSize, 48, 48));
					blocks.get(133).add(new Block(133* blockSize, 7 * blockSize, 48, 48));
					blocks.get(134).add(new Block(134* blockSize, 8 * blockSize, 48, 48));
					blocks.get(135).add(new Block(135* blockSize, 9 * blockSize, 48, 48));
					blocks.get(136).add(new Block(136* blockSize, 8 * blockSize, 48, 48));
					blocks.get(137).add(new Block(137* blockSize, 7 * blockSize, 48, 48));
					blocks.get(137).add(new Block(137* blockSize, 12 * blockSize, 48, 48));
					blocks.get(138).add(new Block(138* blockSize, 6 * blockSize, 48, 48));
					blocks.get(138).add(new Block(138* blockSize, 11 * blockSize, 48, 48));
					blocks.get(139).add(new Block(139* blockSize, 5 * blockSize, 48, 48));
					blocks.get(139).add(new Block(139* blockSize, 10 * blockSize, 48, 48));
					blocks.get(140).add(new Block(140* blockSize, 6 * blockSize, 48, 48));
					blocks.get(140).add(new Block(140* blockSize, 11 * blockSize, 48, 48));
					blocks.get(141).add(new Block(141* blockSize, 7 * blockSize, 48, 48));
					blocks.get(141).add(new Block(141* blockSize, 12 * blockSize, 48, 48));
					blocks.get(142).add(new Block(142* blockSize, 8 * blockSize, 48, 48));
					spikes.get(35).add(new Spike(35* blockSize, 12 * blockSize, 48, 48));
					spikes.get(36).add(new Spike(36* blockSize, 12 * blockSize, 48, 48));
					spikes.get(37).add(new Spike(37* blockSize, 12 * blockSize, 48, 48));
					spikes.get(37).add(new Spike(37* blockSize, 5 * blockSize, 48, 48));
					spikes.get(38).add(new Spike(38* blockSize, 6 * blockSize, 48, 48));
					spikes.get(39).add(new Spike(39* blockSize, 7 * blockSize, 48, 48));
					spikes.get(40).add(new Spike(40* blockSize, 8 * blockSize, 48, 48));
					spikes.get(40).add(new Spike(40* blockSize, 3 * blockSize, 48, 48));
					spikes.get(41).add(new Spike(41* blockSize, 9 * blockSize, 48, 48));
					spikes.get(41).add(new Spike(41* blockSize, 4 * blockSize, 48, 48));
					spikes.get(42).add(new Spike(42* blockSize, 9 * blockSize, 48, 48));
					spikes.get(42).add(new Spike(42* blockSize, 4 * blockSize, 48, 48));
					spikes.get(43).add(new Spike(43* blockSize, 9 * blockSize, 48, 48));
					spikes.get(43).add(new Spike(43* blockSize, 4 * blockSize, 48, 48));
					spikes.get(44).add(new Spike(44* blockSize, 9 * blockSize, 48, 48));
					spikes.get(44).add(new Spike(44* blockSize, 4 * blockSize, 48, 48));
					spikes.get(45).add(new Spike(45* blockSize, 9 * blockSize, 48, 48));
					spikes.get(45).add(new Spike(45* blockSize, 4 * blockSize, 48, 48));
					spikes.get(46).add(new Spike(46* blockSize, 9 * blockSize, 48, 48));
					spikes.get(46).add(new Spike(46* blockSize, 4 * blockSize, 48, 48));
					spikes.get(47).add(new Spike(47* blockSize, 9 * blockSize, 48, 48));
					spikes.get(47).add(new Spike(47* blockSize, 4 * blockSize, 48, 48));
					spikes.get(48).add(new Spike(48* blockSize, 8 * blockSize, 48, 48));
					spikes.get(48).add(new Spike(48* blockSize, 5 * blockSize, 48, 48));
					spikes.get(49).add(new Spike(49* blockSize, 8 * blockSize, 48, 48));
					spikes.get(49).add(new Spike(49* blockSize, 5 * blockSize, 48, 48));
					spikes.get(50).add(new Spike(50* blockSize, 8 * blockSize, 48, 48));
					spikes.get(50).add(new Spike(50* blockSize, 5 * blockSize, 48, 48));
					spikes.get(51).add(new Spike(51* blockSize, 8 * blockSize, 48, 48));
					spikes.get(51).add(new Spike(51* blockSize, 5 * blockSize, 48, 48));
					spikes.get(52).add(new Spike(52* blockSize, 8 * blockSize, 48, 48));
					spikes.get(52).add(new Spike(52* blockSize, 5 * blockSize, 48, 48));
					spikes.get(53).add(new Spike(53* blockSize, 8 * blockSize, 48, 48));
					spikes.get(53).add(new Spike(53* blockSize, 5 * blockSize, 48, 48));
					spikes.get(54).add(new Spike(54* blockSize, 8 * blockSize, 48, 48));
					spikes.get(54).add(new Spike(54* blockSize, 5 * blockSize, 48, 48));
					spikes.get(55).add(new Spike(55* blockSize, 8 * blockSize, 48, 48));
					spikes.get(55).add(new Spike(55* blockSize, 5 * blockSize, 48, 48));
					spikes.get(56).add(new Spike(56* blockSize, 8 * blockSize, 48, 48));
					spikes.get(56).add(new Spike(56* blockSize, 5 * blockSize, 48, 48));
					spikes.get(57).add(new Spike(57* blockSize, 8 * blockSize, 48, 48));
					spikes.get(57).add(new Spike(57* blockSize, 5 * blockSize, 48, 48));
					spikes.get(58).add(new Spike(58* blockSize, 8 * blockSize, 48, 48));
					spikes.get(58).add(new Spike(58* blockSize, 5 * blockSize, 48, 48));
					spikes.get(66).add(new Spike(66* blockSize, 12 * blockSize, 48, 48));
					spikes.get(67).add(new Spike(67* blockSize, 12 * blockSize, 48, 48));
					spikes.get(68).add(new Spike(68* blockSize, 12 * blockSize, 48, 48));
					spikes.get(69).add(new Spike(69* blockSize, 12 * blockSize, 48, 48));
					spikes.get(70).add(new Spike(70* blockSize, 12 * blockSize, 48, 48));
					spikes.get(71).add(new Spike(71* blockSize, 12 * blockSize, 48, 48));
					spikes.get(72).add(new Spike(72* blockSize, 12 * blockSize, 48, 48));
					spikes.get(73).add(new Spike(73* blockSize, 12 * blockSize, 48, 48));
					spikes.get(74).add(new Spike(74* blockSize, 12 * blockSize, 48, 48));
					spikes.get(75).add(new Spike(75* blockSize, 12 * blockSize, 48, 48));
					spikes.get(76).add(new Spike(76* blockSize, 12 * blockSize, 48, 48));
					spikes.get(77).add(new Spike(77* blockSize, 12 * blockSize, 48, 48));
					spikes.get(78).add(new Spike(78* blockSize, 12 * blockSize, 48, 48));
					spikes.get(89).add(new Spike(89* blockSize, 9 * blockSize, 48, 48));
					spikes.get(96).add(new Spike(96* blockSize, 12 * blockSize, 48, 48));
					spikes.get(97).add(new Spike(97* blockSize, 12 * blockSize, 48, 48));
					spikes.get(98).add(new Spike(98* blockSize, 12 * blockSize, 48, 48));
					spikes.get(99).add(new Spike(99* blockSize, 12 * blockSize, 48, 48));
					spikes.get(100).add(new Spike(100* blockSize, 12 * blockSize, 48, 48));
					spikes.get(101).add(new Spike(101* blockSize, 12 * blockSize, 48, 48));
					spikes.get(102).add(new Spike(102* blockSize, 12 * blockSize, 48, 48));
					spikes.get(104).add(new Spike(104* blockSize, 12 * blockSize, 48, 48));
					spikes.get(104).add(new Spike(104* blockSize, 11 * blockSize, 48, 48));
					spikes.get(104).add(new Spike(104* blockSize, 10 * blockSize, 48, 48));
					spikes.get(104).add(new Spike(104* blockSize, 9 * blockSize, 48, 48));
					spikes.get(104).add(new Spike(104* blockSize, 8 * blockSize, 48, 48));
					spikes.get(104).add(new Spike(104* blockSize, 7 * blockSize, 48, 48));
					spikes.get(104).add(new Spike(104* blockSize, 6 * blockSize, 48, 48));
					spikes.get(108).add(new Spike(108* blockSize, 6 * blockSize, 48, 48));
					//spikes.get(111).add(new Spike(111* blockSize, 6 * blockSize, 48, 48));
					spikes.get(150).add(new Spike(150* blockSize, 12 * blockSize, 48, 48));
					spikes.get(151).add(new Spike(151* blockSize, 12 * blockSize, 48, 48));
					spikes.get(158).add(new Spike(158* blockSize, 12 * blockSize, 48, 48));
					spikes.get(159).add(new Spike(159* blockSize, 12 * blockSize, 48, 48));
					spikes.get(165).add(new Spike(165* blockSize, 12 * blockSize, 48, 48));
					spikes.get(166).add(new Spike(166* blockSize, 12 * blockSize, 48, 48));
					spikes.get(173).add(new Spike(173* blockSize, 12 * blockSize, 48, 48));
					spikes.get(174).add(new Spike(174* blockSize, 12 * blockSize, 48, 48));
					spikes.get(179).add(new Spike(179* blockSize, 12 * blockSize, 48, 48));
					spikes.get(180).add(new Spike(180* blockSize, 12 * blockSize, 48, 48));
					spikes.get(184).add(new Spike(184* blockSize, 12 * blockSize, 48, 48));
					spikes.get(185).add(new Spike(185* blockSize, 12 * blockSize, 48, 48));
					spikes.get(190).add(new Spike(190* blockSize, 12 * blockSize, 48, 48));
					spikes.get(191).add(new Spike(191* blockSize, 12 * blockSize, 48, 48));
					spikes.get(196).add(new Spike(196* blockSize, 12 * blockSize, 48, 48));
					spikes.get(197).add(new Spike(197* blockSize, 12 * blockSize, 48, 48));
					spikes.get(202).add(new Spike(202* blockSize, 12 * blockSize, 48, 48));
					spikes.get(203).add(new Spike(203* blockSize, 12 * blockSize, 48, 48));
					spikes.get(207).add(new Spike(207* blockSize, 12 * blockSize, 48, 48));
					spikes.get(208).add(new Spike(208* blockSize, 12 * blockSize, 48, 48));
					portals.get(7).add(new ArrowP(7* blockSize, 11 * blockSize, 48, 96));
					portals.get(31).add(new SpiderP(31* blockSize, 11 * blockSize, 48, 96));
					portals.get(31).add(new SpiderP(31* blockSize, 10 * blockSize, 48, 96));
					portals.get(37).add(new FlyP(37* blockSize, 3 * blockSize, 48, 96));
					portals.get(59).add(new CubeP(59* blockSize, 6 * blockSize, 48, 96));
					portals.get(77).add(new SpiderP(77* blockSize, 7 * blockSize, 48, 96));
					portals.get(91).add(new CubeP(91* blockSize, 3 * blockSize, 48, 96));
					portals.get(97).add(new FlyP(97* blockSize, 4 * blockSize, 48, 96));
					portals.get(97).add(new FlyP(97* blockSize, 3 * blockSize, 48, 96));
					portals.get(116).add(new ArrowP(116* blockSize, 11 * blockSize, 48, 96));
					portals.get(141).add(new CubeP(141* blockSize, 10 * blockSize, 48, 96));
					portals.get(142).add(new CubeP(142* blockSize, 9 * blockSize, 48, 96));
					
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					
				} else if(map == 3) {
				
					
					
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				}
				
				for(int i = 0; i < mapSize; i++) {
					
					for(int j = 0; j < blocks.get(i).size(); j++) {
						
						blocks.get(i).get(j).setup(g);

					}
					
					for(int j = 0; j < spikes.get(i).size(); j++) {
						
						spikes.get(i).get(j).setup(g);

					}
					
					for(int j = 0; j < portals.get(i).size(); j++) {
						
						portals.get(i).get(j).setup(g);

					}
					
				}	
		}
			
		
	}
	
	public void draw(PApplet g, int x) {
			
		while(x + 22 > mapSize) {
			
			x--;
			
		}

			for(int i = x - 2; i < x + 21; i++) {
					
				for(int j = 0; j < blocks.get(i).size(); j++) {
						
					blocks.get(i).get(j).draw(g);					
				}
					
			}
				
			for(int i = x - 2; i < x + 21; i++) {
					
				for(int j = 0; j < portals.get(i).size(); j++) {
						
					portals.get(i).get(j).draw(g);					
				}
					
			}
				
			for(int i = x - 2; i < x + 21; i++) {
					
				for(int j = 0; j < spikes.get(i).size(); j++) {
						
					spikes.get(i).get(j).draw(g);					
				}
					
			}
		
	}
	
	public void setBlocks(ArrayList<ArrayList<Block>> blocks) {
		
		this.blocks = blocks;
		
	}
	
	public void setSpikes(ArrayList<ArrayList<Spike>> spikes) {
		
		this.spikes = spikes;
		
	}
	
	public void setPortals(ArrayList<ArrayList<Portal>> portals) {
		
		this.portals = portals;
		
	}
	
	public ArrayList<ArrayList<Block>> getBlocks() {
		
		return blocks;
		
	}
	
	public ArrayList<ArrayList<Spike>> getSpikes() {
		
		return spikes;
		
	}
	
	public ArrayList<ArrayList<Portal>> getPortals() {
		
		return portals;
		
	}
	
	public void move() {
		// TODO Auto-generated method stub

		if(x < limit - (21 * blockSize)) {
			x += speed;
		} else {
			moveCharacter = true;
			speed = 0;
		}

		for(int i = 0; i < blocks.size(); i++) {
			
			for(int j = 0; j < blocks.get(i).size(); j++) {
				
				blocks.get(i).get(j).move(-speed, 0);
				
			}
			
		}
		
		for(int i = 0; i < portals.size(); i++) {
			
			for(int j = 0; j < portals.get(i).size(); j++) {
				
				portals.get(i).get(j).move(-speed, 0);
				
			}
			
		}
		
		for(int i = 0; i < spikes.size(); i++) {
			
			for(int j = 0; j < spikes.get(i).size(); j++) {
				
				spikes.get(i).get(j).move(-speed, 0);
				
			}
			
		}
		
	}
	public void move(int x) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < blocks.size(); i++) {
			
			for(int j = 0; j < blocks.get(i).size(); j++) {
				
				blocks.get(i).get(j).move(x, 0);
				
			}
			
		}
		
		for(int i = 0; i < portals.size(); i++) {
			
			for(int j = 0; j < portals.get(i).size(); j++) {
				
				portals.get(i).get(j).move(x, 0);
				
			}
			
		}
		
		for(int i = 0; i < spikes.size(); i++) {
			
			for(int j = 0; j < spikes.get(i).size(); j++) {
				
				spikes.get(i).get(j).move(x, 0);
				
			}
			
		}
		
	}

	public void buildMode() {
		
		//buildMode = true;
		
	}
	
	public int getSize() {
		// TODO Auto-generated method stub
		return mapSize;
	}
	
	public boolean getMovingCharacter() {
		
		return moveCharacter;
		
	}

	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}
	
}
