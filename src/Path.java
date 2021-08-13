/**
 * Objects of class path represent pathways of cells to the destination on map objects
 * @author Brendan Bain 251086487
 *
 */

public class Path {
	private Map cityMap;
	
	
	/**
	 * Constructor of class Path. Takes in object theMap of the Map class
	 * @param theMap the map the path will be found on
	 */
	public Path (Map theMap) {
		cityMap = theMap;
	}
	
	
	/**
	 * finds a path to the destination. If destination is reached, program prints number of cells used in the path.
	 * If destination could not be reached, program prints error message
	 */
	public void findPath() {
		
		ArrayStack<MapCell> tracker = new ArrayStack<MapCell> (50, 1, 1);
		try {
			tracker.push(cityMap.getStart());
			cityMap.getStart().markInStack();
	
			while (!tracker.isEmpty() & !tracker.peek().isDestination()) {
				
				if (nextCell(tracker.peek()) != null) {
					tracker.push(nextCell(tracker.peek()));
					tracker.peek().markInStack();
				}
				
				else {
					tracker.peek().markOutStack();
					tracker.pop();
				}
			}
			System.out.println("A path has been found containing " + tracker.size() + " cells");
		}
		catch (EmptyStackException e) {
			System.out.println("Sorry, no path to the destination could be found :(" );
		}
	}
	
	/**
	 * Returns the best neighbouring cell of parameter cell to advance to
	 * @param cell the current cell the path is on
	 * @return The best cell to advance to. If no valid options, returns null
	 */
	private MapCell nextCell(MapCell cell) {
	
//checking neighbouring cells for destination cell
		
		for (int i = 0; i < 4; i++) {
			if (cell.getNeighbour(i) != null) {
				if ((cell.isIntersection() || cell.isStart()) & cell.getNeighbour(i).isDestination()) 
					return cell.getNeighbour(i);
			}
		}
		
		if (cell.getNeighbour(0) != null) {
			if (cell.isNorthRoad() & cell.getNeighbour(0).isDestination())
				return cell.getNeighbour(0);
		}
		
		if (cell.getNeighbour(1) != null) {
			if (cell.isEastRoad() & cell.getNeighbour(1).isDestination())
				return cell.getNeighbour(1);
		}
		
		if (cell.getNeighbour(2) != null) {
			if (cell.isSouthRoad() & cell.getNeighbour(2).isDestination())
				return cell.getNeighbour(2);
		}
		if (cell.getNeighbour(3) != null) {
			if (cell.isWestRoad() & cell.getNeighbour(3).isDestination())
				return cell.getNeighbour(3);
		}
		
		
//checking neighbouring cells for intersection cell
		
		for (int i = 0; i < 4; i++) {
			if (cell.getNeighbour(i) != null) {
				if (cell.getNeighbour(i).isIntersection() & !cell.getNeighbour(i).isMarked()) 
					return cell.getNeighbour(i);
			}
		}
		
//checking neighbouring cells for north, east, south, and west road cells 
		
		if (cell.getNeighbour(0) != null) {
			if (cell.getNeighbour(0).isNorthRoad() & !cell.getNeighbour(0).isMarked())
				return cell.getNeighbour(0);
		}
		
		if (cell.getNeighbour(1) != null) {
			if (cell.getNeighbour(1).isEastRoad() & !cell.getNeighbour(1).isMarked()) 
				return cell.getNeighbour(1);
		}
		
		if (cell.getNeighbour(2) != null) {
			if (cell.getNeighbour(2).isSouthRoad() & !cell.getNeighbour(2).isMarked())
				return cell.getNeighbour(2);
		}
		
		if (cell.getNeighbour(3) != null) {
			if (cell.getNeighbour(3).isWestRoad() & !cell.getNeighbour(3).isMarked())
				return cell.getNeighbour(3);
		}
		
		return null;
	}
	

}
 