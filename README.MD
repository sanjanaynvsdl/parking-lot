# Parking Lot Management System

## Requirements

### Functional Requirements
- **Multi-Floor Support**: Parking lot has multiple floors and each floor has parking spots
- **Entry/Exit Management**: Multiple entry and exit gates in the ground floor
- **Ticket System**: Customer collects ticket at the entry gate, with entry time and slot number
- **Payment Processing**: Customers make payment on exit gate
- **Capacity Management**: If parking lot is full, no entry allowed
- **Vehicle Types**: Support for different vehicle types - auto, bus, bike, EV vehicles
- **Special Features**: Some parking spots have power plugs for EV charging
- **Flexible Allocation**: Small vehicles can be parked in large vehicle spots
- **Smart Allocation**: Allocate nearest available spot
- **Scalability**: System can be extended with more floors and slots in future

### Core Entities
- **Ticket**: Contains Vehicle Number | Entry Gate ID | Entry Time | Slot
- **Bill**: Charges according to spot | Extra charges for electricity usage | Time-based pricing

## System Architecture

```
src/
├── Main.java
├── models/
│   ├── ParkingLot.java
│   ├── ParkingFloor.java
│   ├── ParkingSlot.java
│   ├── EntryGate.java
│   ├── ExitGate.java
│   ├── Vehicle.java
│   ├── Ticket.java
│   └── Bill.java
├── enums/
│   ├── VehicleType.java
│   ├── SlotType.java
│   ├── SlotStatus.java
│   └── FuelType.java
├── interfaces/
│   ├── PricingStrategy.java
│   └── SlotAllocationStrategy.java
└── strategies/
    └── PerHourPricingSt.java
```

## Class Diagram

```
                    ParkingLot
                        |
                        | 1..*
                  ParkingFloor
                        | 1..*
                   ParkingSlot
                   /          \
                  /            \
           EntryGate        ExitGate
                |               |
             Ticket           Bill
                |               |
             Vehicle ───────────┘

    <<interface>>           <<interface>>
  PricingStrategy     SlotAllocationStrategy
        |                        |
  PerHourPricingSt         [implementations]
```

## Design Patterns Used
- **Strategy Pattern**: For pricing and slot allocation strategies
- **Singleton Pattern**: For ParkingLot instance (if applicable)
- **Factory Pattern**: For creating tickets and bills

## How to Run

```powershell
# Compile all Java files
$files = Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName }
javac -d out $files

# Run the application
java -cp out src.Main
```

## Future Enhancements
- Real-time slot availability tracking
- Mobile app integration for booking
- Payment gateway integration
- Analytics dashboard for parking statistics
- VIP/Reserved parking slots
- Multi-level security implementation
