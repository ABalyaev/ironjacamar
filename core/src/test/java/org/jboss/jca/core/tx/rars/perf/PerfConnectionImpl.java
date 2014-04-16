/*
 * IronJacamar, a Java EE Connector Architecture implementation
 * Copyright 2013, Red Hat Inc, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.core.tx.rars.perf;

import org.jboss.logging.Logger;

/**
 * PerfConnectionImpl
 */
public class PerfConnectionImpl implements PerfConnection
{
   /** The logger */
   private static Logger log = Logger.getLogger(PerfConnectionImpl.class.getName());

   /** ManagedConnection */
   private PerfManagedConnection mc;

   /** ManagedConnectionFactory */
   private PerfManagedConnectionFactory mcf;

   /**
    * Default constructor
    * @param mc PerfManagedConnection
    * @param mcf PerfManagedConnectionFactory
    */
   public PerfConnectionImpl(PerfManagedConnection mc, PerfManagedConnectionFactory mcf)
   {
      this.mc = mc;
      this.mcf = mcf;
   }

   /**
    * {@inheritDoc}
    */
   public void close()
   {
      mc.closeHandle(this);
   }

   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();

      sb.append("PerfConnection@").append(Integer.toHexString(System.identityHashCode(this)));
      sb.append("[mc=").append(mc);
      sb.append("]");

      return sb.toString();
   }
}
